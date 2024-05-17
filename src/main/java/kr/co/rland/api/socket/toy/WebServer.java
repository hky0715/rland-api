package kr.co.rland.api.socket.toy;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class WebServer {
    public static void main(String[] args) throws IOException {
    // port를 만드는순간 입/출력 버퍼를 생성함
        ServerSocket serverSocket = new ServerSocket(10004);
        System.out.println("Listening.. at port 10004");

        boolean run = true;

        List<Socket> clients = new ArrayList<>();

        while(run) {
            // 데이터 전용 socket이 accept 하는 순간 만들어짐!
            // client가 오지 않으면 blocking상태.. data accept 할거야! 어 근데 accept 할것이 없네...... 기다리자...
            Socket socket = serverSocket.accept();
            clients.add(socket);

            // new Thread(()->{
                System.out.printf("connected from %s\n", socket.getInetAddress());

                try(InputStream ois = socket.getInputStream();
                    OutputStream os = socket.getOutputStream();
                    // reader : 귀! 암리스닝~~
                    BufferedReader in = new BufferedReader(new InputStreamReader(ois));
                    PrintWriter out = new PrintWriter(os, true);) {

                    // while(true) {
                        String line = in.readLine(); // data 언제오시죠??? data가 올 때까지 blocking한당
                        System.out.printf("%s: %s\n", socket.getInetAddress(), line);

                        String payload = """
                                <html>
                                    <head>
                                        <title>Hello!</title>
                                    </head>
                                    <body>
                                        <h1>Welcome... Newlec server</h1>
                                        <div> hehehe </div>
                                    </body>
                                </html
                                """;

                        StringBuilder builder = new StringBuilder();

                        // status line
                        builder.append("HTTP/1.1 200 OK\r\n");

                        // *-header                                              
                        builder.append("Content-Length: " + payload.length());
                        builder.append("Content-Type: text/html");
                        builder.append("Date:" + new Date().toString());
                        builder.append("Server: Newlec");  

                        out.println(builder.toString());
                        out.println("\r\n");    // CRLF
                        out.println(payload);

                        if("bye".equals(line))
                            break;
                    // }
                    // 예외처리를 하면 close를 자동으로 해주는 기능이 추가되어따(JDK1.8)
                    // in.close();
                    // out.close();
                    // os.close();
                    // ois.close();
                       

                } catch(IOException e) {
                    e.printStackTrace();
                }
                
            // }).start();
            // });
            socket.close(); 
        }

        // sub thread들이 다 끝나면 그때 main thread를 닫을 수 있을까??
        // join() 메소드를 쓰면 sub thread를 기다렸다가 같이 간다! 라고 해주는것이다....
        //serverSocket.close();
        // Scanner scan = '문자를 숫자로 변환해서 읽어들임';
        // BufferedInputStream bis = '문자열을 한글자 한글자 버퍼에 넣어 담아요';
    }
}

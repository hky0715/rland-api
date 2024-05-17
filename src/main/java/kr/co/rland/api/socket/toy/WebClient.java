package kr.co.rland.api.socket.toy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class WebClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.0.54", 8080); 
        System.out.printf("connected to %s\n",socket.getInetAddress());

        InputStream ois = socket.getInputStream();
        OutputStream sos = socket.getOutputStream();

        BufferedReader in = new BufferedReader(new InputStreamReader(ois));
        PrintWriter out = new PrintWriter(sos, true);

        String requestLine = "GET / HTTP/1.1\r\n";
        String requestHeader = "Host: 127.0.0.1\r\n\r\n";

        String reqString = requestLine+requestHeader;

        // 브라우저가 요청하는 것처럼 서버에 요청!
        out.println(reqString);

        for(int i=0; i<30; i++) {
            // 서버에서 보내준 문서를 읽어서
            String resp = in.readLine();
            // 콘솔에 출력하기
            System.out.println(resp);
        }
        
        in.close();
        out.close();
        ois.close();
        sos.close();

    }
}
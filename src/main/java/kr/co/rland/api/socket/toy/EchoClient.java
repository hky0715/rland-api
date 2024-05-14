package kr.co.rland.api.socket.toy;

import java.net.Socket;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        // 서버소켓을 사용하지 않고 직접 데이터소켓을 만든다!
        Socket socket = new Socket("127.0.0.1", 10004); // 클라이언트는 자기가 포트를 binding하는게 아님. data port는 서버가 남는걸 알아서 주는것.
        System.out.printf("connected from %s\n", socket.getInetAddress());

        InputStream ois = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        // reader : 귀! 암리스닝~~
        BufferedReader in = new BufferedReader(new InputStreamReader(ois));
        PrintWriter out = new PrintWriter(os, true);

        // 1. 사용자로부터 메아리를 할 수 있는 메시지를 입력받음
        Scanner scan = new Scanner(System.in);
        String msg;
        System.out.println("msg: ");
        msg = scan.nextLine();

        // 2. 사용자로부터 입력받은 메시지를 전송한다.
        out.println(msg);

        // 3. 서버로부터 전달된 line을 읽어온다.
        String line = in.readLine();

        // 4. 콘솔에 line을 출력한다.
        System.out.println(line); // echo!!!!

        in.close();
        out.close();
        os.close();
        ois.close();
    }
}

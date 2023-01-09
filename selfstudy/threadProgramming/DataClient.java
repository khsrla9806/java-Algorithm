package selfstudy.threadProgramming;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class DataClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 6013); // "127.0.0.1"에서 6013 포트로 소켓 연결
        while (true) {
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            /* 소켓으로부터 데이터를 읽음 */
            String message = br.readLine();
            System.out.println(message);

            if (message.equals("그만")) {
                socket.close();
                System.out.println("종료합니다.");
                break;
            }
        }
    }
}

package selfstudy.threadProgramming;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class DataServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6013); // 서버 소켓을 생성 (port 6013)
        Socket client = server.accept(); // 6013 포트에서 listening 하고 있음

        while (true) {
            PrintWriter pout = new PrintWriter(client.getOutputStream(), true);

            System.out.print("메시지를 입력 (그만을 입력하면 종료) >>  ");
            /* 소컷에 데이터를 작성 */
            String inputData = new Scanner(System.in).nextLine();
            pout.println(inputData);

            /* 소캣 연결을 끊음 */
            if (inputData.equals("그만")) {
                client.close();
                System.out.println("연결종료");
                break;
            }
        }
    }
}

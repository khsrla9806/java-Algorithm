package sorfteer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 주행거리비교하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] distance = bufferedReader.readLine().split(" ");

        int A = Integer.parseInt(distance[0]);
        int B = Integer.parseInt(distance[1]);

        if (A > B) {
            System.out.println("A");
        } else if (A < B) {
            System.out.println("B");
        } else {
            System.out.println("same");
        }
    }
}

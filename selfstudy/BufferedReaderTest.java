package selfstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력 테스트
        System.out.print("문자열을 입력하시오 : ");
        String inputData = bufferedReader.readLine();
        System.out.println("입력된 문자열 : " + inputData);

        // 공백이 포함된 문자열 테스트
        System.out.print("공백으로 구분하여 단어 3개를 입력 : ");
        String[] splitData = bufferedReader.readLine().split(" ");
        for (int i = 0; i < splitData.length; i++) {
            System.out.println((i + 1) + "번째 입력된 데이터 : " + splitData[i]);
        }

        // 숫자 입력 테스트
        System.out.print("첫 번째 숫자를 입력하세요 : ");
        int a = Integer.valueOf(bufferedReader.readLine());
        System.out.print("두 번째 숫자를 입력하세요 : ");
        int b = Integer.valueOf(bufferedReader.readLine());
        System.out.println("두 숫자의 합은 = " + (a + b));

        bufferedReader.close();
    }
}

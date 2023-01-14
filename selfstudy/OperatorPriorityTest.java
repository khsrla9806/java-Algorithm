package selfstudy;

import java.util.Stack;

public class OperatorPriorityTest {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        char c = '1';
        int k = 0;

        // 첫 번째 isEmpty() test
        stack.push('3'); // if문 실행 No

        // 두 번째 stack.peek() < c test
        c = '6'; // if문 실행 No

        // 세 번째 k-- > 0 test
        k = 1;

        if (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
            System.out.println("동작!!");
            System.out.println("k는 " + k); // 후치 연산자 --가 실행된 값이 출력
        }
    }
}

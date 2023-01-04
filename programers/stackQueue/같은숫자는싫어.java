package programers.stackQueue;

import java.util.*;

// 같은 숫자는 싫어
public class 같은숫자는싫어 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 3, 0, 1, 1};
        Stack<Integer> stack = new Stack<>();

        for (int element : arr) {
            if (stack.empty()) {
                stack.push(element);
                continue;
            }

            if (element != stack.peek()) {
                stack.push(element);
            }
        }

        int[] answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        Arrays.stream(answer).forEach(data -> System.out.println(data));
    }
}

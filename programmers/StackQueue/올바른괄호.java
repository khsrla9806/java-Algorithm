package programmers.StackQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) {
        List<String> str = List.of("()()", "(())()", ")()(", "(()(");
        str.stream().forEach(s -> System.out.println(solution(s)));
        /* answer
        * true
        * true
        * false
        * false
        */
    }

    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char str : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(str);
                continue;
            }

            if (str == '(') {
                stack.push(str);
            } else {
                if (stack.peek() == str) {
                    stack.push(str);
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
}

package programmers.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 영어끝말잇기 {
    public static void main(String[] args) {
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};

        System.out.println(Arrays.toString(solution(2, words)));
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        int failMan = 0;
        int turn = 0;

        List<String> data = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (i % n == 0) {
                turn++;
            }
            if (data.contains(words[i])) {
                failMan = i % n + 1;
                break;
            }
            if (i != 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                failMan = i % n + 1;
                break;
            }
            data.add(words[i]);
        }

        if (data.size() == words.length || failMan == 0) {
            turn = 0;
        }

        answer[0] = failMan;
        answer[1] = turn;

        return answer;
    }
}

package programmers.kakaoBlindRecruitment;

import java.util.*;

public class 압축 {
    public static void main(String[] args) {
        String msg = "KAKAO";

        System.out.println(Arrays.toString(solution(msg)));
    }

    public static int[] solution(String msg) {
        String[] initiateData = {"A", "B", "C", "D", "E", "F",
                "G", "H", "I", "J", "K",
                "L", "M", "N", "O", "P",
                "Q", "R", "S", "T", "U",
                "V", "W", "X", "Y", "Z"};
        List<String> data = new ArrayList<>(Arrays.asList(initiateData));
        List<Integer> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>(Arrays.asList(msg.split("")));

        while (!queue.isEmpty()) {
            String w = queue.poll();

            while (!queue.isEmpty()) {
                String c = queue.peek();
                if (data.contains(w + c)) {
                    w += queue.poll();
                    continue;
                }
                data.add(w + c);
                break;
            }
            result.add(data.indexOf(w) + 1);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}

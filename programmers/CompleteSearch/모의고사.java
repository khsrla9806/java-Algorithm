package programmers.CompleteSearch;

import java.util.*;

public class 모의고사 {
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};
        System.out.println(Arrays.toString(solution(answers)));
    }

    public static int[] solution(int[] answers) {
        int[][] giveUpMath = {
                {},
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] result = {0, 0, 0, 0};

        for (int i = 1; i < giveUpMath.length; i++) {
            for (int j = 0; j < answers.length; j++) {
                if (answers[j] == giveUpMath[i][j % giveUpMath[i].length]) {
                    result[i]++;
                }
            }
        }

        int max = Math.max(result[1], Math.max(result[2], result[3]));
        int maxCount= 0;
        for (int i = 1; i < 4; i++) {
            if (max == result[i]) {
                maxCount++;
            }
        }
        int[] answer = new int[maxCount];

        int index = 0;
        for (int i = 1; i < 4; i++) {
            if (result[i] == max) {
                answer[index] = i;
                index++;
            }
        }

        return answer;
    }
}

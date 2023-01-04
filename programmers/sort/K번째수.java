package programmers.sort;

import java.util.Arrays;

public class K번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(solution(array, commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int k = commands[i][2] - 1;
            answer[i] = sliceAndSortArr(array, commands[i][0], commands[i][1])[k];
        }

        return answer;
    }

    public  static int[] sliceAndSortArr(int[] array, int startIndex, int endIndex) {
        int[] slicedArray = Arrays.copyOfRange(array, startIndex - 1, endIndex);
        Arrays.sort(slicedArray);
        return slicedArray;
    }
}

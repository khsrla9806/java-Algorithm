package programmers.CompleteSearch;


import java.util.Arrays;

public class 최소직사각형 {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int x = 0;
        int y = 0;

        for (int[] size : sizes) {
            Arrays.sort(size);
            x = Math.max(x, size[0]);
            y = Math.max(y, size[1]);
        }

        return x * y;
    }
}

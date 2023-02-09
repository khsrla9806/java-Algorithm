package programmers.practice;

public class 선입선출스케쥴링 {
    public static void main(String[] args) {
        int n = 140;
        int[] cores = {1, 2, 3, 3, 5, 6, 2, 3, 4, 5, 6, 1, 4, 3, 4, 5};

        System.out.println(solution(n, cores));

    }

    public static int solution(int n, int[] cores) {
        int answer = 0;

        int minTime = 0;
        int maxTime = cores[0] * n; // 최대 time 초기화

        int time = 0;
        int m = 0; // time 까지 처리된 작업 수

        while (minTime <= maxTime) {
            int midTime = (minTime + maxTime) / 2;
            int count = cores.length;

            if (midTime != 0) {
                for (int c : cores) {
                    count += midTime / c;
                }
            }

            if (count >= n) {
                maxTime = midTime - 1;
                time = midTime;
                m = count;
            } else {
                minTime = midTime + 1;
            }
        }

        m -= n;
        for (int i = cores.length - 1; i >= 0; i--) {
            if (time % cores[i] == 0) {
                if (m == 0) {
                    return i + 1;
                }
                m--;
            }
        }

        return answer;
    }
}

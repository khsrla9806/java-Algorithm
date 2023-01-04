package programers.DFSandBFS;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 타겟넘버 {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(+numbers[0]);
        queue.offer(-numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            for (int j = 1; j <= Math.pow(2, i); j++) {
                int number = queue.poll();
                queue.offer(number + numbers[i]);
                queue.offer(number - numbers[i]);
            }
        }

        return Collections.frequency(queue, target);
    }
}

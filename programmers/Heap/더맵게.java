package programmers.Heap;

import java.util.*;

public class 더맵게 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;

        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int number : scoville) {
            queue.offer(number);
        }

        while (!queue.isEmpty()) {
            if (queue.peek() >= k) {
                break;
            }

            if (queue.size() == 1) {
                answer = -1;
                break;
            }

            queue.offer(queue.poll() + (queue.poll() * 2));
            answer++;
        }

        System.out.println(answer);
    }
}

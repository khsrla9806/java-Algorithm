package selfstudy;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxAndMinHeap {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{5, 7, 1, 2, 4, 6, 3};

        /* 최소 힙 */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer x : array) {
            minHeap.offer(x);
        }

        System.out.println("[ 최소 힙 결과 ]");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " "); // 1 2 3 4 5 6 7
        }

        System.out.println("\n");

        /* 최대 힙 */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer x : array) {
            maxHeap.offer(x);
        }

        System.out.println("[ 최대 힙 결과 ]");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " "); // 7 6 5 4 3 2 1
        }
    }
}

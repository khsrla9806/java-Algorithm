package selfstudy;

import java.util.LinkedList;
import java.util.Queue;

public class BFSExample {
    // 0은 사용하지 않지만, 0~9까지의 노드 방문처리를 false로 초기화
    public static boolean[] visit = new boolean[10];

    public static int[][] graph = {
            {},           // 0번 노드와 인접한 노드들
            {2, 3, 4},    // 1번 노드와 인접한 노드들
            {1, 4, 8},    // 2번 노드와 인접한 노드들
            {1, 5},       // 3번 노드와 인접한 노드들
            {1, 2, 6, 7}, // 4번 노드와 인접한 노드들
            {3},          // 5번 노드와 인접한 노드들
            {4},          // 6번 노드와 인접한 노드들
            {4},          // 7번 노드와 인접한 노드들
            {2, 9},       // 8번 노드와 인접한 노드들
            {8}           // 9번 노드와 인접한 노드들
    };

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        bfs(1, queue);
    }

    public static void bfs(int node, Queue<Integer> queue) {
        visit[node] = true;
        queue.offer(node);
        System.out.print(node + " ");

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int n : graph[currentNode]) {
                if (!visit[n]) {
                    visit[n] = true;
                    queue.offer(n);
                    System.out.print(n + " ");
                }
            }
        }
    }
}

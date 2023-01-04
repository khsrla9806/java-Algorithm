package selfstudy;

import java.util.Stack;

public class DFSExample {
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
        Stack<Integer> stack = new Stack<>();
        dfs(1, stack); // dfs 탐색 시작
    }

    public static void dfs(int node, Stack<Integer> stack) {
        stack.push(node);
        visit[node] = true;
        System.out.print(node + " ");

        while (!stack.empty()) {
            // 현재 노드를 가져옵니다. (아직 스택에서 제거는 하지 않음)
            int currentNode = stack.peek();
            // 근접하는 노드가 모두 방문처리 되어있는지 확인하기 위한 불값
            boolean hasNearbyNode = false;

            for (int n : graph[currentNode]) {
                if (!visit[n]) { // 근접 노드가 방문처리 되어있지 않다면 방문처리를 진행
                    visit[n] = true;
                    hasNearbyNode = true; // 방문처리 되어있지 않은 노드가 존재
                    stack.push(n); // 스택에 해당 노드를 추가해줍니다.
                    System.out.print(n + " ");
                    break;
                }
            }

            if (!hasNearbyNode) { // 근접 노드가 모두 방문처리되어 있다면
                stack.pop(); // 해당 노드는 탐색이 모두 끝났기 때문에 stack에서 제거합니다.
            }
        }
    }
}

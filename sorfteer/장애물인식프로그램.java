package sorfteer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 장애물인식프로그램 {
    private final int[][] MOVE = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // 오른쪽, 왼쪽, 아래쪽, 위쪽
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(data[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count = 0;
                if (graph[i][j] == 0) {
                    continue;
                }
                dfs(i, j, graph, N);
                result.add(count);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        result.stream().forEach(System.out::println);
    }

    public static void dfs(int i, int j, int[][] graph, int N) {
        if (i < 0 || j < 0 || i >= N || j >= N) {
            return;
        }

        if (graph[i][j] == 0) {
            return;
        }

        if (graph[i][j] == 1) {
            graph[i][j] = 0;
            count++;
            dfs(i, j + 1, graph, N);
            dfs(i, j - 1, graph, N);
            dfs(i + 1, j, graph, N);
            dfs(i - 1, j, graph, N);
        }
    }
}

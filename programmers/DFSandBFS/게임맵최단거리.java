package programmers.DFSandBFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        if (solution(maps) == 11) {
            System.out.println("맞았습니다.");
        } else {
            System.out.println("출력된 " + solution(maps) + "은 정답이 아닙니다.");
        }
    }

    // 동, 서, 남, 북
    private static final int[][] MOVE = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int solution(int[][] maps) {
        return bfs(maps);
    }

    public static int bfs(int[][] maps) {
        int result = -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});

        while (!queue.isEmpty()) {
            int[] position = queue.poll();

            if (maps[position[0]][position[1]] == 0) {
                continue;
            }
            maps[position[0]][position[1]] = 0;

            if (position[0] == maps.length - 1 && position[1] == maps[0].length - 1) {
                result = position[2];
                break;
            }

            for (int[] move : MOVE) {
                int[] newPosition = {position[0] + move[0], position[1] + move[1], position[2] + 1};
                if (newPosition[0] < 0
                        || newPosition[0] >= maps.length
                        || newPosition[1] < 0
                        || newPosition[1] >= maps[0].length) {
                    continue;
                }
                if (maps[newPosition[0]][newPosition[1]] == 0) {
                    continue;
                }
                queue.offer(newPosition);
            }
        }

        return result;
    }
}

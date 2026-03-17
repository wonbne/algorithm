import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    static int n, min;
    static int[][] arr;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine().trim());
            arr = new int[n][n];
            visited = new boolean[n][n];
            min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                String s = br.readLine().trim();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.charAt(j) - '0';
                }
            }
            bfs();
            System.out.println("#"+t+" "+min);

        }
    }

    public static void bfs() {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(o->o[2]));
        queue.offer(new int[] { 0, 0, 0 });
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = tmp[0] + dx[d];
                int ny = tmp[1] + dy[d];
                int cnt = tmp[2];
                if (nx == n - 1 && ny == n - 1) {
                    min = Math.min(min, cnt);
                    continue;
                }
                if (cnt >= min)
                    continue;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] { nx, ny, cnt + arr[nx][ny] });
                }
            }
        }
    }
}

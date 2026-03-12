import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static int n;
    // 상 하 좌 우 왼위 오위 왼아 오아
    static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
    static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine().trim());
            arr = new int[n][n];
            total = 0;
            // 폭탄 -2, 폭탄 없으면 -1

            for (int i = 0; i < n; i++) {
                String s = br.readLine().trim();
                for (int j = 0; j < n; j++) {
                    if (s.charAt(j) == '.') {
                        arr[i][j] = -1;

                    } else {
                        arr[i][j] = -2;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == -1) {
                        int count = 0;
                        for (int d = 0; d < 8; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                                continue;
                            if (arr[nx][ny] == -2) {
                                count++;
                            }
                        }
                        if (count == 0) {
                            bfs(i, j);
                            total++;
                        }
                    }

                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == -1) {
                        bfs(i, j);
                        total++;
                    }
                }
            }
            System.out.println("#" + tc + " " + total);
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });
        arr[x][y] = 0;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int cX = tmp[0];
            int cY = tmp[1];
            int count = 0;
            for (int d = 0; d < 8; d++) {
                int nx = cX + dx[d];
                int ny = cY + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;
                if (arr[nx][ny] == -2) {
                    count++;
                }
            }
            arr[cX][cY] = count;

            if (count == 0) {
                for (int d = 0; d < 8; d++) {
                    int nx = cX + dx[d];
                    int ny = cY + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] == -1) {
                        arr[nx][ny] = 0;
                        queue.offer(new int[] { nx, ny });
                    }
                }
            }
        }
    }
}

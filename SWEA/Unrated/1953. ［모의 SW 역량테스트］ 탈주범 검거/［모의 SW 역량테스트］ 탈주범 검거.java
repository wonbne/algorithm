import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static boolean[][] visited;
    static int n, m, r, c, L, pCount;

    // 상 하 좌 우
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int type = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= type; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            pCount = 0;

            arr = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            cal(r, c);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j])
                        pCount++;
                }
            }

            System.out.println("#" + tc + " " + pCount);
        }
    }

    static void cal(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();

        visited[x][y] = true;

        queue.offer(new int[] { x, y, 1 });

        while (!queue.isEmpty()) {

            int[] tmp = queue.poll();

            int nx = tmp[0];
            int ny = tmp[1];
            int time = tmp[2];

            int type = arr[nx][ny];

            if (time == L)
                continue;

            if (type == 1) {

                // 상
                if (nx - 1 >= 0 && arr[nx - 1][ny] != 0 && !visited[nx - 1][ny]) {
                    if (arr[nx - 1][ny] != 3 && arr[nx - 1][ny] != 4 && arr[nx - 1][ny] != 7) {
                        visited[nx - 1][ny] = true;
                        queue.offer(new int[] { nx - 1, ny, time + 1 });
                    }
                }

                // 하
                if (nx + 1 < n && arr[nx + 1][ny] != 0 && !visited[nx + 1][ny]) {
                    if (arr[nx + 1][ny] != 3 && arr[nx + 1][ny] != 5 && arr[nx + 1][ny] != 6) {
                        visited[nx + 1][ny] = true;
                        queue.offer(new int[] { nx + 1, ny, time + 1 });
                    }
                }

                // 좌
                if (ny - 1 >= 0 && arr[nx][ny - 1] != 0 && !visited[nx][ny - 1]) {
                    if (arr[nx][ny - 1] != 2 && arr[nx][ny - 1] != 6 && arr[nx][ny - 1] != 7) {
                        visited[nx][ny - 1] = true;
                        queue.offer(new int[] { nx, ny - 1, time + 1 });
                    }
                }

                // 우
                if (ny + 1 < m && arr[nx][ny + 1] != 0 && !visited[nx][ny + 1]) {
                    if (arr[nx][ny + 1] != 2 && arr[nx][ny + 1] != 4 && arr[nx][ny + 1] != 5) {
                        visited[nx][ny + 1] = true;
                        queue.offer(new int[] { nx, ny + 1, time + 1 });
                    }
                }

            } else if (type == 2) {

                // 상
                if (nx - 1 >= 0 && arr[nx - 1][ny] != 0 && !visited[nx - 1][ny]) {
                    if (arr[nx - 1][ny] != 3 && arr[nx - 1][ny] != 4 && arr[nx - 1][ny] != 7) {
                        visited[nx - 1][ny] = true;
                        queue.offer(new int[] { nx - 1, ny, time + 1 });
                    }
                }

                // 하
                if (nx + 1 < n && arr[nx + 1][ny] != 0 && !visited[nx + 1][ny]) {
                    if (arr[nx + 1][ny] != 3 && arr[nx + 1][ny] != 5 && arr[nx + 1][ny] != 6) {
                        visited[nx + 1][ny] = true;
                        queue.offer(new int[] { nx + 1, ny, time + 1 });
                    }
                }

            } else if (type == 3) {

                // 좌
                if (ny - 1 >= 0 && arr[nx][ny - 1] != 0 && !visited[nx][ny - 1]) {
                    if (arr[nx][ny - 1] != 2 && arr[nx][ny - 1] != 6 && arr[nx][ny - 1] != 7) {
                        visited[nx][ny - 1] = true;
                        queue.offer(new int[] { nx, ny - 1, time + 1 });
                    }
                }

                // 우
                if (ny + 1 < m && arr[nx][ny + 1] != 0 && !visited[nx][ny + 1]) {
                    if (arr[nx][ny + 1] != 2 && arr[nx][ny + 1] != 4 && arr[nx][ny + 1] != 5) {
                        visited[nx][ny + 1] = true;
                        queue.offer(new int[] { nx, ny + 1, time + 1 });
                    }
                }

            } else if (type == 4) {

                // 상
                if (nx - 1 >= 0 && arr[nx - 1][ny] != 0 && !visited[nx - 1][ny]) {
                    if (arr[nx - 1][ny] != 3 && arr[nx - 1][ny] != 4 && arr[nx - 1][ny] != 7) {
                        visited[nx - 1][ny] = true;
                        queue.offer(new int[] { nx - 1, ny, time + 1 });
                    }
                }

                // 우
                if (ny + 1 < m && arr[nx][ny + 1] != 0 && !visited[nx][ny + 1]) {
                    if (arr[nx][ny + 1] != 2 && arr[nx][ny + 1] != 4 && arr[nx][ny + 1] != 5) {
                        visited[nx][ny + 1] = true;
                        queue.offer(new int[] { nx, ny + 1, time + 1 });
                    }
                }

            } else if (type == 5) {

                // 우
                if (ny + 1 < m && arr[nx][ny + 1] != 0 && !visited[nx][ny + 1]) {
                    if (arr[nx][ny + 1] != 2 && arr[nx][ny + 1] != 4 && arr[nx][ny + 1] != 5) {
                        visited[nx][ny + 1] = true;
                        queue.offer(new int[] { nx, ny + 1, time + 1 });
                    }
                }

                // 하
                if (nx + 1 < n && arr[nx + 1][ny] != 0 && !visited[nx + 1][ny]) {
                    if (arr[nx + 1][ny] != 3 && arr[nx + 1][ny] != 5 && arr[nx + 1][ny] != 6) {
                        visited[nx + 1][ny] = true;
                        queue.offer(new int[] { nx + 1, ny, time + 1 });
                    }
                }

            } else if (type == 6) {

                // 하
                if (nx + 1 < n && arr[nx + 1][ny] != 0 && !visited[nx + 1][ny]) {
                    if (arr[nx + 1][ny] != 3 && arr[nx + 1][ny] != 5 && arr[nx + 1][ny] != 6) {
                        visited[nx + 1][ny] = true;
                        queue.offer(new int[] { nx + 1, ny, time + 1 });
                    }
                }

                // 좌
                if (ny - 1 >= 0 && arr[nx][ny - 1] != 0 && !visited[nx][ny - 1]) {
                    if (arr[nx][ny - 1] != 2 && arr[nx][ny - 1] != 6 && arr[nx][ny - 1] != 7) {
                        visited[nx][ny - 1] = true;
                        queue.offer(new int[] { nx, ny - 1, time + 1 });
                    }
                }

            } else if (type == 7) {

                // 상
                if (nx - 1 >= 0 && arr[nx - 1][ny] != 0 && !visited[nx - 1][ny]) {
                    if (arr[nx - 1][ny] != 3 && arr[nx - 1][ny] != 4 && arr[nx - 1][ny] != 7) {
                        visited[nx - 1][ny] = true;
                        queue.offer(new int[] { nx - 1, ny, time + 1 });
                    }
                }

                // 좌
                if (ny - 1 >= 0 && arr[nx][ny - 1] != 0 && !visited[nx][ny - 1]) {
                    if (arr[nx][ny - 1] != 2 && arr[nx][ny - 1] != 6 && arr[nx][ny - 1] != 7) {
                        visited[nx][ny - 1] = true;
                        queue.offer(new int[] { nx, ny - 1, time + 1 });
                    }
                }
            }
        }
    }
}
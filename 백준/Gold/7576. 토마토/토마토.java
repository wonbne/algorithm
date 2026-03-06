import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int m, n, count, totalCount;
    // 상 하 좌 우
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        totalCount = Integer.MAX_VALUE;
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == -1)
                    visited[i][j] = true;
            }
        }

        bfs();
        boolean is = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    is = false;
                    break;
                }
            }
        }
        System.out.println(is?totalCount:-1);
        

    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    queue.offer(new int[] { i, j, 0 });
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = tmp[0] + dx[d];
                int ny = tmp[1] + dy[d];
                int t = tmp[2];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (arr[nx][ny] == 0 && !visited[nx][ny]) {
                        int nCount = t + 1;
                        arr[nx][ny] = 1;
                        max = Math.max(max, nCount);
                        queue.offer(new int[] { nx, ny, nCount });
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        totalCount = Math.min(max, totalCount);
    }
}

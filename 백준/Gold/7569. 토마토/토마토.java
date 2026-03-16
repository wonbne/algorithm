import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] arr;
    static int m, n, h, count, totalCount, l;
    // 상 하 좌 우 상 하
    static int[] dx = { -1, 1, 0, 0, 0, 0 };
    static int[] dy = { 0, 0, -1, 1, 0, 0 };
    static int[] dh = { 0, 0, 0, 0, -1, 1 };
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        totalCount = Integer.MAX_VALUE;
        arr = new int[h][n][m];
        visited = new boolean[h][n][m];
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < m; j++) {
                    arr[k][i][j] = Integer.parseInt(st.nextToken());
                    if (arr[k][i][j] == -1)
                        visited[k][i][j] = true;
                }
            }
        }
        bfs();
        boolean is = true;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[k][i][j]) {
                        is = false;
                        break;
                    }
                }
            }
        }
        System.out.println(is ? totalCount : -1);

    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int max = 0;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[k][i][j] == 1) {
                        queue.offer(new int[] { k, i, j, 0 });
                        visited[k][i][j] = true;
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            for (int d = 0; d < 6; d++) {
                int nh = tmp[0] + dh[d];
                int nx = tmp[1] + dx[d];
                int ny = tmp[2] + dy[d];
                int t = tmp[3];
                if (nh>=0 && nh<h && nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (arr[nh][nx][ny] == 0 && !visited[nh][nx][ny]) {
                        int nCount = t + 1;
                        arr[nh][nx][ny] = 1;
                        max = Math.max(max, nCount);
                        queue.offer(new int[] { nh, nx, ny, nCount });
                        visited[nh][nx][ny] = true;
                    }
                }
            }
        }
        totalCount = Math.min(max, totalCount);
    }
}
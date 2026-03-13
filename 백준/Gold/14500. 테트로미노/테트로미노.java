import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, max;
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        max = 0;
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, checkT(i, j));
                visited[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void dfs(int x, int y, int count, int sum) {
        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue;
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, count + 1, sum + arr[nx][ny]);
                visited[nx][ny] = false;
            }
        }

    }

    static int checkT(int x, int y) {
        int maxT = 0;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue;

            int sum = arr[x][y];
            if (d == 0) {
                if (ny - 1 >= 0 && ny +1 < m) {
                    sum += arr[nx][ny] + arr[nx][ny - 1] + arr[nx][ny + 1];
                }
            } else if (d == 1) {
                if (ny - 1 >= 0 && ny +1 < m) {
                    sum += arr[nx][ny] + arr[nx][ny - 1] + arr[nx][ny + 1];
                }
            } else if (d == 2) {
                if (nx - 1 >= 0 && nx +1< n) {
                    sum += arr[nx][ny] + arr[nx-1][ny] + arr[nx+1][ny];
                }
            } else if (d == 3) {
                if (nx - 1 >= 0 && nx +1 < n) {
                    sum += arr[nx][ny] + arr[nx-1][ny] + arr[nx+1][ny];
                }
            }
            maxT = Math.max(maxT, sum);
        }
        return maxT;
    }
}

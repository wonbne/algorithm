import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n, m, t;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] bead = new int[m][3];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            bead[i][0] = Integer.parseInt(st.nextToken());
            bead[i][1] = Integer.parseInt(st.nextToken());
            bead[i][2] = 1;
        }

        int time = 0;
        while (time != t) {
            int[][] next = new int[m][2];

            for (int i = 0; i < m; i++) {
                if (bead[i][2] == 0) {
                    next[i][0] = bead[i][0];
                    next[i][1] = bead[i][1];
                    continue;
                }

                int r = bead[i][0], c = bead[i][1];
                int maxVal = -1;
                int nr = r, nc = c;

                for (int d = 0; d < 4; d++) {
                    int nx = r + dx[d], ny = c + dy[d];
                    if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
                    if (arr[nx][ny] > maxVal) {
                        maxVal = arr[nx][ny];
                    }
                }

                for (int d = 0; d < 4; d++) {
                    int nx = r + dx[d], ny = c + dy[d];
                    if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
                    if (arr[nx][ny] == maxVal) {
                        nr = nx;
                        nc = ny;
                        break;
                    }
                }

                next[i][0] = nr;
                next[i][1] = nc;
            }

            for (int i = 0; i < m; i++) {
                bead[i][0] = next[i][0];
                bead[i][1] = next[i][1];
            }

            int[][] count = new int[n + 1][n + 1];
            for (int i = 0; i < m; i++) {
                if (bead[i][2] == 0) continue;
                count[bead[i][0]][bead[i][1]]++;
            }
            for (int i = 0; i < m; i++) {
                if (bead[i][2] == 0) continue;
                if (count[bead[i][0]][bead[i][1]] >= 2) {
                    bead[i][2] = 0;
                }
            }
            time++;
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            if (bead[i][2] == 1) {
                count++;
            }
        }

        System.out.println(count);
    }
}
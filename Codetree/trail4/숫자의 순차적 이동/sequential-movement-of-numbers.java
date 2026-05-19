import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n, m;
    //상 하 좌 우 우상 우하 좌하 좌상
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            move();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }

    public static void move() {
        int idx = 1;

        while (idx <= n * n) {

            int x = -1;
            int y = -1;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] == idx) {
                        x = i;
                        y = j;
                    }
                }
            }

            int max = -1;
            int mx = -1;
            int my = -1;

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx > n || ny > n || nx <= 0 || ny <= 0) continue;

                if (max < arr[nx][ny]) {
                    max = arr[nx][ny];
                    mx = nx;
                    my = ny;
                }
            }

            int tmp = arr[x][y];
            arr[x][y] = arr[mx][my];
            arr[mx][my] = tmp;

            idx++;
        }
    }
}
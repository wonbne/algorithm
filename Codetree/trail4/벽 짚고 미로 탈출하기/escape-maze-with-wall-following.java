import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] arr;
    static int n, x, y;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        arr = new char[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String s = br.readLine().trim();

            for (int j = 1; j <= n; j++) {
                arr[i][j] = s.charAt(j - 1);
            }
        }

        int dir = 2; // 0 : 좌 1 : 상 2 : 우 3 : 하

        int nx = x;
        int ny = y;

        int sx = x;
        int sy = y;
        int sdir = dir;

        int count = 0;

        while (true) {

            nx += dx[dir];
            ny += dy[dir];
            count++;

            // 탈출
            if (nx <= 0 || ny <= 0 || nx > n || ny > n) {
                break;
            }

            // 벽
            if (arr[nx][ny] == '#') {

                nx -= dx[dir];
                ny -= dy[dir];
                count--;

                dir = (dir + 3) % 4;

                // 원래 상태 복귀
                if (nx == sx && ny == sy && dir == sdir) {
                    count = -1;
                    break;
                }

                continue;
            }

            int rx = nx + dx[(dir + 1) % 4];
            int ry = ny + dy[(dir + 1) % 4];

            if (rx <= 0 || ry <= 0 || rx > n || ry > n || arr[rx][ry] != '#') {
                dir = (dir + 1) % 4;
            }

            // 원래 상태 복귀
            if (nx == sx && ny == sy && dir == sdir) {
                count = -1;
                break;
            }
        }

        System.out.println(count);
    }
}
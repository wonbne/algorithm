import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n;
    // 0: 상, 1: 하, 2: 좌, 3: 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 4면에서 진입 시뮬레이션
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, simulate(n, i, 0));
            max = Math.max(max, simulate(1, i, 1));
            max = Math.max(max, simulate(i, n, 2));
            max = Math.max(max, simulate(i, 1, 3));
        }

        System.out.println(max);
    }


    public static int simulate(int r, int c, int d) {
        int count = 1;

        while (r >= 1 && r <= n && c >= 1 && c <= n) {
            if (arr[r][c] == 1) { // '/' 모양
                if (d == 0) d = 3;      // 상 -> 우
                else if (d == 1) d = 2; // 하 -> 좌
                else if (d == 2) d = 1; // 좌 -> 하
                else if (d == 3) d = 0; // 우 -> 상
            }
            else if (arr[r][c] == 2) { // '\' 모양
                if (d == 0) d = 2;      // 상 -> 좌
                else if (d == 1) d = 3; // 하 -> 우
                else if (d == 2) d = 0; // 좌 -> 상
                else if (d == 3) d = 1; // 우 -> 하
            }

            r += dx[d];
            c += dy[d];
            count++;
        }

        return count;
    }
}
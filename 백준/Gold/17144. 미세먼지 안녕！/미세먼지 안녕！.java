import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int r, c, t;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] air;
    static int[][] diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new int[r][c];
        air = new int[2][2];
        diff = new int[r][c];
        int airCount = 0;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    air[airCount][0] = i;
                    air[airCount++][1] = j;
                }
            }
        }
        for(int i = 0; i<t; i++){
            spread();
            purify();
        }
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] > 0) {
                    count += arr[i][j];
                }
            }
        }
        System.out.println(count);
    }

    public static void spread() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] > 0) {
                    queue.offer(new int[] { i, j });
                }
            }
        }
        for(int i = 0; i<r; i++){
            Arrays.fill(diff[i], 0);
        }
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int count = 0;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= r || ny >= c || nx < 0 || ny < 0 || arr[nx][ny] == -1)
                    continue;

                diff[nx][ny] += arr[x][y] / 5;
                count++;
            }
            arr[x][y] -= arr[x][y] / 5 * count;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] += diff[i][j];
            }
        }
    }

    public static void purify() {
        for (int k = 0; k < 2; k++) {
            int x = air[k][0];
            int y = air[k][1];
            if (k == 0) {
                // 하
                for (int i = x - 1; i >= 1; i--) {
                    arr[i][y] = arr[i - 1][y];
                }
                // 좌
                for (int i = 0; i < c - 1; i++) {
                    arr[0][i] = arr[0][i + 1];
                }
                // 상
                for (int i = 0; i < x; i++) {
                    arr[i][c - 1] = arr[i + 1][c - 1];
                }
                // 우
                for (int i = c - 1; i >= 2; i--) {
                    arr[x][i] = arr[x][i - 1];
                }
                arr[x][y + 1] = 0;
            } else {
                // 상
                for (int i = x + 1; i < r - 1; i++) {
                    arr[i][y] = arr[i + 1][y];
                }

                // 좌
                for (int i = 0; i < c - 1; i++) {
                    arr[r - 1][i] = arr[r - 1][i + 1];
                }
                // 하
                for (int i = r - 1; i >= x + 1; i--) {
                    arr[i][c - 1] = arr[i - 1][c - 1];
                }
                // 우
                for (int i = c - 1; i >= 2; i--) {
                    arr[x][i] = arr[x][i - 1];
                }
                arr[x][y + 1] = 0;
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int count = arr[r][c];

        arr[r][c] = 0;


        for (int d = 0; d < 4; d++) {
            for (int i = 1; i < count; i++) {
                int nx = r + dx[d] * i;
                int ny = c + dy[d] * i;

                if(nx>n || ny >n || nx<=0 || ny <= 0) continue;

                arr[nx][ny] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            int idx = n;
            for (int j = n; j >= 1; j--) {
                if (arr[j][i] != 0) {
                    arr[idx][i] = arr[j][i];
                    if(idx != j) arr[j][i] = 0;
                    idx--;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }


}
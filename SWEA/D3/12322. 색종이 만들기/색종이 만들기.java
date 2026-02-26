import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static int[][] arr;
    public static int n;
    public static int wPaper;
    public static int bPaper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine().trim());
            arr = new int[n][n];
            wPaper = 0;
            bPaper = 0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0, 0, n);
            System.out.println("#" + tc + " " + wPaper + " " + bPaper);
        }
    }

    public static void dfs(int x, int y, int size) {

        if (check(x, y, size, 0)) {
            wPaper++;
            return;
        } else if (check(x, y, size, 1)) {
            bPaper++;
            return;
        }

        int nSize = size / 2;
        dfs(x, y, nSize);
        dfs(x + nSize, y, nSize);
        dfs(x, y + nSize, nSize);
        dfs(x + nSize, y + nSize, nSize);

    }

    public static boolean check(int x, int y, int size, int color) {
        // 0은 하얀색, 1은 파란색
        boolean is = true;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != color) {
                    is = false;
                }
            }
        }
        if (is) {
            return true;
        } else {
            return false;
        }
    }
}
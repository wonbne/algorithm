import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static int n;
    static int l;
    static int maxPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            maxPoint = 0;
            arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, 0, 0);
            System.out.println("#" + tc + " " + maxPoint);
        }
    }

    public static void dfs(int idx, int calSum, int pointSum) {
        if (idx == n) {
            if (calSum <= l) {
                maxPoint = Math.max(maxPoint, pointSum);
            }
            return;
        }

        // 이번 인덱스 포함
        dfs(idx + 1, calSum + arr[idx][1], pointSum + arr[idx][0]);
        // 이번 인덱스 미포함
        dfs(idx + 1, calSum, pointSum);
    }

}
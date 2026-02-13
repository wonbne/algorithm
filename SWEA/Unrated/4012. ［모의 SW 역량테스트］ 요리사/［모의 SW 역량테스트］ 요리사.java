import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int[][] arr;
    static int answer;
    static boolean[] is;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            answer = Integer.MAX_VALUE;
            is = new boolean[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0, 0);
            System.out.println("#" + tc + " " + answer);
        }

    }

    public static void dfs(int idx, int count) {
        if (count == n / 2) {
            answer = Math.min(answer, cal());
            return;
        }
        if(idx == n) return;

        is[idx] = true;
        dfs(idx + 1, count + 1);

        is[idx] = false;
        dfs(idx + 1, count);
    }

    public static int cal() {
        int sumA = 0;
        int sumB = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (is[i] && is[j])
                    sumA += arr[i][j];
                else if (!is[i] && !is[j])
                    sumB += arr[i][j];
            }
        }
        return Math.abs(sumA - sumB);
    }
}
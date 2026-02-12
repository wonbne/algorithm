import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] arr;
    static int count;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            count = 0;
            dfs(0, 0);
            System.out.println("#" + tc + " " + count);
        }
    }

    public static void dfs(int idx, int sum) {
        if (idx == n) {
            if (sum == k) {
                count++;
            }
            return;
        }

        // 이번 인덱스 포함
        dfs(idx + 1, sum + arr[idx]);
        // 이번 인덱스 미포함
        dfs(idx + 1, sum);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int n;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for(int tc = 1; tc<= t; tc++){
            n = Integer.parseInt(br.readLine().trim());
            String x = br.readLine().trim();
            String y = br.readLine().trim();
            dp = new int[n+1][n+1];
            for(int i = 1; i<=n; i++){
                for(int j = 1; j<=n; j++){
                    if(x.charAt(i-1) == y.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }

                }
            }

            double ans = (double)dp[n][n] / n * 100;
            System.out.printf("#%d %.2f\n", tc, ans);
        }
    }
}
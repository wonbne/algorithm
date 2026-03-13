import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int max = 100000;
        int[] coin = { 5000, 1000, 500, 100, 50, 10, 5, 1 };

        for (int tc = 1; tc <= t; tc++) {

            int n = Integer.parseInt(br.readLine().trim()) / 10;
            int[] dp = new int[max + 1];
            int[] last = new int[max + 1];
            int[] count = new int[coin.length];
            dp[0] = 0;
            for (int i = 1; i <= max; i++) {
                dp[i] = Integer.MAX_VALUE;
            }
            for(int i = 1; i<= max; i++){
                for(int j = 0; j<coin.length; j++){
                    if(i>=coin[j] && dp[i-coin[j]]+1 < dp[i]){
                        dp[i] = dp[i-coin[j]]+1;
                        last[i] = j;
                    }
                }
            }

            int amount = n;
            while(amount>0){
                int idx = last[amount];
                count[idx]++;
                amount -= coin[idx];
            }
            System.out.println("#" + tc+" ");
            for(int i = 0; i<coin.length; i++){
                System.out.print(count[i]+" ");
            }
            System.out.println();
        }
    }

}

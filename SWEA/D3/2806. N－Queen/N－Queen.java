import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int[] col;
    static int n;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for(int tc = 1; tc<=t; tc++){
            n = Integer.parseInt(br.readLine().trim());
            col = new int[n];
            ans = 0;
            dfs(0);
            System.out.println("#"+tc+" "+ans);
        }
    }
    public static void dfs(int row){
        if(row == n){
            ans++;
            return;
        }

        for(int i = 0; i<n; i++){
            col[row] = i;
            if(is(row)){
                dfs(row+1);
            }
        }
    }

    static boolean is(int row){
        for(int i = 0; i<row; i++){
            if(col[i] == col[row]){
                return false;
            }
            if(Math.abs(row-i) == Math.abs(col[row] - col[i])){
                return false;
            }
        }
        return true;
    }
}

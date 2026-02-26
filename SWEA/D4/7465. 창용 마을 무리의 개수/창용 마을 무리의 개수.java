import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static boolean[] visited;
    static int count;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for(int tc = 1; tc<=t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr = new int[n+1][n+1];
            visited = new boolean[n+1];
            count = 0;
            for(int k = 0; k<m; k++){
                st = new StringTokenizer(br.readLine().trim());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                arr[i][j] = arr[j][i] = 1;
            }
            for(int i = 1; i<=n; i++){
                if(!visited[i]){
                    dfs(i);
                    count++;
                }
            }
            System.out.println("#"+tc+" "+count);
        }
    }

    static void dfs(int x){
        visited[x] = true;
        for(int i = 1; i<=n; i++){
            if(arr[i][x] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}
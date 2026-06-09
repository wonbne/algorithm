import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static int n;
    static int[][] arr;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[1001];
        arr = new int[n][2];
        max = 0;
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        System.out.println(max);
    }

    public static void dfs(int depth, int count){
        if(depth == n){
            max = Math.max(max, count);
            return;
        }

        int start = arr[depth][0];
        int end = arr[depth][1];

        boolean can = true;

        for(int i = start; i<=end; i++){
            if(visited[i]){
                can = false;
                break;
            }
        }

        if(can){
            for(int i = start; i <= end; i++) {
                visited[i] = true;
            }

            dfs(depth + 1, count + 1);

            for(int i = start; i <= end; i++) {
                visited[i] = false;
            }
        }
        
        dfs(depth+1, count);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for(int tc = 1; tc<=t; tc++){
            n = Integer.parseInt(br.readLine().trim());
            arr = new int[n+2][2];
            visited = new boolean[n+1];
            min = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int oX = Integer.parseInt(st.nextToken());
            int oY = Integer.parseInt(st.nextToken());
            int hX = Integer.parseInt(st.nextToken());
            int hY = Integer.parseInt(st.nextToken());
            arr[0][0] = oX;
            arr[0][1] = oY;
            for(int i = 1; i<=n; i++){
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            arr[n+1][0] = hX;
            arr[n+1][1] = hY;
            cal(0,0,0);
            System.out.println("#"+tc+" "+ min);
        }
    }

    static void cal(int depth,int sum, int current){
        if(sum>min){
            return;
        }

        if(depth == n){
            int dist = Math.abs(arr[current][0]- arr[n+1][0]) + Math.abs(arr[current][1] - arr[n+1][1]);
            min = Math.min(min, sum+dist);
            return;
        }

        for(int i = 1; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                int dist = Math.abs(arr[current][0]-arr[i][0]) + Math.abs(arr[current][1]-arr[i][1]);
                cal(depth+1, sum+dist, i);
                visited[i] = false;
            }    
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int[][] dist;
    static final int INF = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for(int tc = 1; tc<=t; tc++){
            StringTokenizer st= new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            dist = new int[n+1][n+1];
            for(int i = 1; i<=n; i++){
                for(int j = 1; j<=n; j++){
                    dist[i][j] = Integer.parseInt(st.nextToken());
                    if(i!=j && dist[i][j] == 0){
                        dist[i][j] = INF;
                    }
                }
            }

            for(int x = 1; x<=n; x++){
                for(int sta = 1; sta<=n; sta++){
                    if(dist[sta][x] == INF) continue;
                    for(int ed = 1; ed<=n; ed++){
                        if(dist[x][ed] == INF) continue;
                        dist[sta][ed] = Math.min(dist[sta][ed], dist[sta][x] + dist[x][ed]);
                    }
                }
            }
            int min = Integer.MAX_VALUE;

            for(int i = 1; i<=n; i++){
                int sum = 0;
                for(int j = 1; j<=n; j++){
                    sum += dist[i][j];
                }
                min = Math.min(sum, min);
            }
            System.out.println("#" + tc+" "+min);
        }
    }
}
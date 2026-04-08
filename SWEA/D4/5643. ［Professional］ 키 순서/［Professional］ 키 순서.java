import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n, m;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine().trim());
            m = Integer.parseInt(br.readLine().trim());
            dist = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i != j) {
                        dist[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            for(int i = 0; i<m; i++){
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                dist[a][b] = 1;
            }

            for(int x = 1; x<=n; x++){
                for(int st = 1; st<=n; st++){
                    if(dist[st][x] == Integer.MAX_VALUE) continue;
                    for(int ed = 1; ed<=n; ed++){
                        if(dist[x][ed] == Integer.MAX_VALUE ) continue;
                        dist[st][ed] = Math.min(dist[st][ed], dist[st][x]+dist[x][ed]);
                    }
                }
            }

            boolean check = true;
            for(int i = 1; i<=n; i++){
                if(dist[i][i] <0){
                    check = false;
                    break;
                }
            }

            int count = 0;
            for(int i = 1; i<=n; i++){
                int c = 0;
                for(int j = 1; j<=n; j++){
                    if(i == j) continue;
                    if(dist[i][j] != Integer.MAX_VALUE || dist[j][i] != Integer.MAX_VALUE){
                        c++;
                    }
                }
                if(c == n-1) count++;
            }
            System.out.println("#"+tc+" "+count);

        }

    }
}
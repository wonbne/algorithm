import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int m,n;
    static int[][] dist;
    static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        m = Integer.parseInt(br.readLine().trim());
        dist = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(i == j) continue;
                dist[i][j] = INF;
            }
        }
        for(int i = 0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[start][end] = Math.min(dist[start][end], cost);
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
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(dist[i][j] == INF) System.out.print(0 + " ");
                else System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
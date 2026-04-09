import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] dist;
    static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(i==j) continue;
                dist[i][j] = INF;
            }
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = 1;
        }

        for(int x = 1; x<=n; x++){
            for(int sta = 1; sta<=n; sta++){
                if(dist[sta][x] == INF) continue;
                for(int ed = 1; ed<=n; ed++){
                    if(dist[x][ed] == INF) continue;
                    dist[sta][ed] = Math.min(dist[sta][x]+dist[x][ed], dist[sta][ed]);
                }
            }
        }
        int count = 0;
        for(int i = 1; i<=n; i++){
            int sum = 0;
            for(int j = 1; j<=n; j++){
                if(dist[i][j] != INF || dist[j][i] != INF){
                    if(i!=j)sum++;
                }
            }
            if(sum == n-1) count++;
        }
        System.out.println(count);
    }
}
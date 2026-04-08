import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int  n,m,r;
    static int[][] dist;
    static int[] items;
    static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        items = new int[n+1];
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 1; i<=n; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }


        dist = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(i == j) continue;
                dist[i][j] = INF;
            }
        }
        for(int i = 1; i<=r; i++){
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
            dist[b][a] = Math.min(dist[b][a], c);
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
        int max = 0;

        for(int i = 1; i<=n; i++){
            int sum = 0;
            for(int j = 1; j<=n; j++){
                if(dist[i][j] <=m) {
                    sum += items[j];
                }
            }
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}
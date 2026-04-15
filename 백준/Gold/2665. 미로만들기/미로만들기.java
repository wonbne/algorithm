import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int n, count;
    static int INF = 987654321;
    static int[][] dist, map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        dist = new int[n+1][n+1];
        map = new int[n+1][n+1];
        count = 0;
        for(int i = 1; i<=n; i++){
            String s = br.readLine().trim();
            for(int j = 1; j<=n; j++){
                map[i][j] = s.charAt(j-1) - '0';
                dist[i][j] = INF;
            }
        }
        dij();
        System.out.println(count);
    }

    public static void dij(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[]{1,1,0});
        dist[1][1] = 0;
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            int x = tmp[0];
            int y = tmp[1];

            if(x == n && y == n){
                count = dist[n][n];
            }

            for(int d = 0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx <=0 || nx >n || ny <= 0 || ny >n) continue;

                int cost = 0;
                if(map[nx][ny] == 0) cost = 1;

                if(dist[nx][ny] > dist[x][y] + cost){
                    dist[nx][ny] = dist[x][y] + cost;
                    pq.add(new int[]{nx,ny, dist[nx][ny]});
                }
            }
        }
    }
}
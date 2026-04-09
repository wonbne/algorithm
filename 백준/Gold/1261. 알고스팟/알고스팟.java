import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        dist = new int[n+1][m+1];
        for(int i = 1; i<=n; i++){
            String s = br.readLine().trim();
            for(int j = 1; j<=m; j++){
                map[i][j] = s.charAt(j-1) -'0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dij();
        System.out.println(dist[n][m]);
    }

    public static void dij(){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) ->Integer.compare(a[2],b[2]));
        queue.add(new int[]{1,1,0});
        dist[1][1] = 0;
        while(!queue.isEmpty()){
            int[] tmp= queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            for(int d = 0; d<4; d++){
                int nx = x+dx[d];
                int ny = y+dy[d];
                if(nx>n || ny >m || nx<=0 || ny <= 0) continue;

                if(dist[nx][ny] > dist[x][y] + map[nx][ny]){
                    dist[nx][ny] = dist[x][y] + map[nx][ny];
                    queue.add(new int[]{nx,ny,dist[nx][ny]});
                }
            }
        }
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m,max;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        max = 0;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int count){
        if(count == 3){
            bfs();
            return;
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(count+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs(){
        int[][] tmpMap = new int[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                tmpMap[i][j] = map[i][j];
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(tmpMap[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            for(int d = 0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx>=n || nx <0 || ny>=m || ny<0 || tmpMap[nx][ny] == 1 || tmpMap[nx][ny] == 2) continue;

                tmpMap[nx][ny] = 2;
                q.add(new int[]{nx,ny});
            }
        }
        int c = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(tmpMap[i][j] == 0){
                    c++;
                }
            }
        }
        max = Math.max(max, c);
    }
}
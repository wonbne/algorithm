import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int x, y, min;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        map = new int[x][y];
        visited = new boolean[x][y][2];
        min = Integer.MAX_VALUE;
        for(int i = 0; i<x; i++){
            String s = br.readLine().trim();
            for(int j = 0; j<y; j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }
        bfs();
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1,1});
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(tmp[0] == x-1 && tmp[1] == y-1){
                min = Math.min(min, tmp[3]);
            }
            for(int d = 0; d<4; d++){
                int nx = tmp[0] + dx[d];
                int ny = tmp[1] + dy[d];
                if(nx>=x || ny >= y || nx<0 || ny <0) continue;

                if(map[nx][ny] == 1){
                    if(tmp[2] == 1 && !visited[nx][ny][0]) {
                        visited[nx][ny][0] = true;
                        queue.offer(new int[]{nx, ny, 0, tmp[3] + 1});
                    }
                } else if(map[nx][ny] == 0){
                    if(!visited[nx][ny][tmp[2]]){
                        visited[nx][ny][tmp[2]] = true;
                        queue.offer(new int[]{nx,ny,tmp[2],tmp[3]+1});
                    }
                }
            }
        }
    }
}
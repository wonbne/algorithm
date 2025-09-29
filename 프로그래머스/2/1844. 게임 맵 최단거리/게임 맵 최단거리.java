import java.util.*;
class Solution {
    int n;
    int m;
    int[][] map;
    boolean[][] visited;
    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};
    int[][] distance;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        map = maps;
        visited = new boolean[n][m];
        distance = new int[n][m];
        distance[0][0] = 1;
        bfs(0,0);
        return distance[n-1][m-1] == 0 ? -1 : distance[n-1][m-1];
    }
    public void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x,y});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i = 0; i<4; i++){
                int nx = dx[i] + cx;
                int ny = dy[i] + cy;
                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if(!visited[nx][ny] && map[nx][ny] == 1){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx,ny});
                        distance[nx][ny] = distance[cx][cy] + 1;
                    }
                }
            }
        }

    }
}
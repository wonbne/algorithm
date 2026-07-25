import java.util.*;

class Solution {
    
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static boolean[][] visited;
    static int n,m;
    static int min = Integer.MAX_VALUE;
    public int solution(int[][] maps) {
        int answer = 0;
        map = maps;
        m = maps[0].length;
        n = maps.length;
        visited = new boolean[n][m];
        bfs();
        if(min == Integer.MAX_VALUE){
            min = -1;
        }
        
        answer = min;
        return answer;
    }
    
    public void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            int count = tmp[2];
            for(int d = 0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx == n-1 && ny == m-1){
                    min = Math.min(min, count+1);
                }
                
                if(nx < 0 || ny < 0 || nx>=n || ny >= m || map[nx][ny] == 0 || visited[nx][ny] == true){
                    continue;
                }
                
                
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny,count+1});
            }
        }
        
        
    }
}
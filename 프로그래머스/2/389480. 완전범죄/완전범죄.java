import java.util.*;

class Solution {
    static int[][] info;
    static int min,n,m;
    static boolean[][][] visited;
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        this.info = info;
        this.n = n;
        this.m = m;
        visited = new boolean[info.length+1][n][m];
        min = Integer.MAX_VALUE;
        dfs(0,0,0);
        if(min == Integer.MAX_VALUE){
            answer = -1;
        } else{
            answer = min;
        }
        return answer;
    }
    
    public void dfs(int a, int b, int depth){
        
        if(a >= n || b >= m){
            return;
        }
        
        if(a >= min){
            return;
        }
        
        if( depth == info.length){
            min = Math.min(min, a);
            return;
        }
        
        if(visited[depth][a][b]){
            return;
        }
        
        visited[depth][a][b] = true;

        dfs(a, b + info[depth][1], depth+1);

        dfs(a + info[depth][0], b, depth+1);
    }
}
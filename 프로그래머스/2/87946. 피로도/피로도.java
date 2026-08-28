import java.util.*;

class Solution {
    
    static int[][] dungeon;
    static int answer;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        dungeon = dungeons;
        visited = new boolean[dungeon.length];
        
        //1. 최소 필요 피로도 2. 소모 피로도
        
        dfs(0,0,k);
        
        return answer;
    }
    
    public void dfs(int cnt, int check, int k){
        
        if(cnt == dungeon.length){
            answer = Math.max(answer, check);
            return;
        }
        
        for(int i = 0; i<dungeon.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(dungeon[i][0] <= k){
                    dfs(cnt+1, check+1, k-dungeon[i][1]);
                } else{
                    dfs(cnt+1, check, k);
                }
                visited[i] = false;
            }
        }
    }
}
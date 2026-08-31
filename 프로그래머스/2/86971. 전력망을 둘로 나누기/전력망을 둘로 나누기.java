import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] graph;
    static boolean[] visited; 
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int j = 0; j<wires.length; j++){
                    
            visited = new boolean[n+1];
            graph = new ArrayList[n+1];
            
            for(int i = 0; i<=n; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i<wires.length; i++){
                if(i == j) continue;
                
                graph[wires[i][0]].add(wires[i][1]);
                graph[wires[i][1]].add(wires[i][0]);
            }
            
            int count = dfs(1);
            
            int rest = n - count;
            
            int diff = Math.abs(count - rest);

            answer = Math.min(diff, answer);
            
        }

        return answer;
    }
    
    public int dfs(int node){
        
        visited[node] = true;
        
        int count = 1;
        
        for(int next : graph[node]){
            if(!visited[next]){
                count += dfs(next);
            }
        }
        
        return count;
    }
    
}
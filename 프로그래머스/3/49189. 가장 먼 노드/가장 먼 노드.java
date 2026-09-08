import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int max, answer;
    
    public int solution(int n, int[][] edge) {
        answer = 0;
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        max = 0;
        
        for(int i = 0; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<edge.length; i++){
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        bfs();
        
        return answer;
    }
    
    public void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        visited[1] = true;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            
            for(int i : graph[tmp[0]]){
                if(!visited[i]){
                    q.add(new int[]{i, tmp[1]+1});
                    visited[i] = true;
                }
            }
            if(tmp[1] > max){
                max = tmp[1];
                answer = 1;
            } else if(tmp[1] == max){
                answer++;
            }
            
        }

        
    }
    
}
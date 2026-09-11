import java.util.*;

class Solution {
    static ArrayList<Integer>[] win;
    static ArrayList<Integer>[] lose;
    static int num;
    public int solution(int n, int[][] results) {
        int answer = 0;
        num = n;
        win = new ArrayList[n+1];
        lose = new ArrayList[n+1];
        
        for(int i = 0; i<n+1; i++){
            win[i] = new ArrayList<>();
            lose[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<results.length; i++){
            win[results[i][0]].add(results[i][1]);                                     lose[results[i][1]].add(results[i][0]);
        }
        
        for(int i = 1; i<n+1; i++){
            int sum = bfs(i, win) + bfs(i, lose);
            
            if(n-1 == sum){
                answer++;
            }
            
        }
        
        return answer;
    }
    
    public int bfs(int idx, ArrayList<Integer>[] list){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[num+1];
        
        q.add(idx);
        visited[idx] = true;
        
        int count = 0;
        while(!q.isEmpty()){
            int tmp = q.poll();
            
            for(int next : list[tmp]){
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
        
        return count;
    }
}
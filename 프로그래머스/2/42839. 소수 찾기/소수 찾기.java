import java.util.*;

class Solution {
    
    static boolean[] visited;
    static String number;
    static int answer;
    static Set<Integer> set = new HashSet<>();
    
    
    public int solution(String numbers) {
        answer = 0;
        number = numbers;
        visited = new boolean[numbers.length()];
        
        for(int i = 1; i<=numbers.length(); i++){
            dfs("", 0, i);
        }
        
        answer = set.size();
        
        
        return answer;
    }
    
    public void dfs(String s,int cnt, int len){
        
        if(cnt == len){
            int val = Integer.parseInt(s);
            boolean check = true;
            
            if(val <= 1){
                return ;
            }
            for(int i =2; i<val; i++){
                if(val % i == 0){
                    check = false;
                    break;
                }
            }
            
            if(check){
                set.add(val);
                return;
            } else{
                return;
            }
            
        }
        
        for(int i = 0; i<visited.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            dfs(s + number.charAt(i), cnt+1, len);
            visited[i] = false;
        }
        
    }
    
}   
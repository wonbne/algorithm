import java.util.*;

class Solution {
    static boolean[] visited;
    static int total;
    static Set<Set<String>> ans;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        visited = new boolean[user_id.length];
        total = 0;
        
        ans = new HashSet<>();
        List<String> list = new ArrayList<>();
        dfs(0, user_id, banned_id,list);
        
        answer = ans.size();
        
        return answer;
    }
    
    public static boolean check(String id, String ban){
        boolean is = true;
        
        if(id.length() != ban.length()) return false;
        
        for(int i = 0; i<id.length(); i++){
            if(ban.charAt(i) == '*') continue;
            if(id.charAt(i) != ban.charAt(i)){
                is = false;
                break;
            }
        }
        return is;
    }
    
    public static void dfs(int count, String[] user_id, String[] banned_id, List<String> list){
        if(count == banned_id.length){
            ans.add(new HashSet(list));
            return;
        }
        
        for(int i = 0; i<user_id.length; i++){
            if(check(user_id[i], banned_id[count])){
                if(!visited[i]){
                    visited[i] = true;
                    list.add(user_id[i]);
                    dfs(count+1, user_id, banned_id,list);
                    list.remove(list.size()-1);
                    visited[i] = false;
                }
            }
        
        }
    }
    
}
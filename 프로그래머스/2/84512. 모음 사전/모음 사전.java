import java.util.*;

class Solution {
    static HashMap<String, Integer> map;
    static String[] alp = {"A", "E", "I", "O", "U"};
    static int idx = 0;
    public int solution(String word) {
        int answer = 0;
        map = new HashMap<>();
        
        dfs("", 0);
        
        answer = map.get(word);
        
        return answer;
    }
    
    public void dfs(String s, int depth){


        map.put(s, idx);
        idx++;
        if(depth == 5) return ;
        
        for(int i = 0; i<5; i++){
            dfs(s+alp[i], depth+1);
        }
    }
    
}
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book, (a,b) -> b.length() - a.length());
        Set<String> set = new HashSet<>();
        
        for(String s : phone_book){
            
            if(set.contains(s)){
                answer = false;
                break;
            }
            
            for(int i = 0; i<=s.length(); i++){
                set.add(s.substring(0, i));
            }
        }
        return answer;
    }
}
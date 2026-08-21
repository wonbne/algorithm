import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] st = new String[numbers.length];
        
        for(int i = 0; i<st.length; i++){
            st[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(st, (a,b) -> (b+a).compareTo(a+b));
        
        for(int i = 0; i<st.length; i++){
            answer+=st[i];
        }
        
        if(st[0].equals("0")) return "0";
        
        return answer;
    }
}
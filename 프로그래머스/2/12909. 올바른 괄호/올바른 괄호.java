import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean ans= true;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            } else{
                if(stack.isEmpty()){
                    ans = false;
                } else{
                    char c = stack.pop();
                    if(c != '('){
                        ans = false;
                    }
                }
            }
        }

        if(!stack.isEmpty()){
            ans = false;
        }
        
        return ans;
    }
}
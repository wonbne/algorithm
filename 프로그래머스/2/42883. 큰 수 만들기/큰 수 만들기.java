import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        char[] stack = new char[number.length()];
        int top = 0;
        
        for(char c : number.toCharArray()){
            while(top > 0 &&  k > 0 && stack[top -1] < c){
                k--;
                top--;
            }
            
            stack[top++] = c;
        }
        
        top -= k;
        
        return new String(stack, 0, top);
    }
}
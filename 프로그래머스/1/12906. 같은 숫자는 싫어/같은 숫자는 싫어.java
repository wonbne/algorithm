import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        
        int now;
        
        for(int c : arr){
            now = c;
            if(stack.isEmpty() || now != stack.peek()){
                stack.push(c);
            } else{
                continue;
            }
        }

        int[] answer = new int[stack.size()];
        
        int index = 0;
        
        for(int c : stack){
            answer[index++] = c;
        }
        
        return answer;
    }
}
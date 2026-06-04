import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        int startIdx = 0;
        int count = 0;
        for(int i = 0; i<s.length(); i++){
            startIdx = i % s.length();
            boolean check = true;
            for(int j = 0; j<s.length(); j++){
                int idx = (startIdx + j) % s.length();
                if(s.charAt(idx) == '[' || s.charAt(idx) == '(' || s.charAt(idx) == '{'){
                    stack.push(s.charAt(idx));
                } else if(s.charAt(idx) == ']'){
                    if(!stack.isEmpty() && stack.pop() == '['){
                        continue;
                    } else{
                        check = false;
                        break;
                    }
                }
                 else if(s.charAt(idx) == '}'){
                    if(!stack.isEmpty() && stack.pop() == '{'){
                        continue;
                    } else{
                        check = false;
                        break;
                    }
                }
                 else if(s.charAt(idx) == ')'){
                    if(!stack.isEmpty() && stack.pop() == '('){
                        continue;
                    } else{
                        check = false;
                        break;
                    }
                }
            }
            if(check && stack.isEmpty()){
                count++;
            }
            stack.clear();
        }
        int answer = count;
        return answer;
    }
}
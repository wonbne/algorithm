import java.util.*;
class Solution {
    static char[] status;
    static Stack<Integer> stack;
    static int[] prev, next;
    static int k, n;
    
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        status = new char[n];
        stack = new Stack<>();
        this.n = n;
        this.k = k;
        next = new int[n];
        prev = new int[n];
        
        for(int i = 0; i<n; i++){
            prev[i] = i-1;
            next[i] = i+1;
        }

        Arrays.fill(status, 'O');
        for(int i = 0; i<cmd.length; i++){
            char c = cmd[i].charAt(0);
            if(c == 'C' || c == 'Z'){
                command(c, 0);
            }else{
                command(c, Integer.parseInt(cmd[i].substring(2)));
            }
        }
        answer = new String(status);
        return answer;
    }                         
    public static void command(char c, int x){
        if(c == 'U'){
            for(int i = 0; i<x; i++){
                k = prev[k];
            }
        } else if(c == 'D'){
            for(int i = 0; i<x; i++){
                k = next[k];
            }
        } else if(c == 'C'){
            status[k] = 'X';
            stack.push(k);
            if(prev[k] >= 0){
                next[prev[k]] = next[k];
            }
            if(next[k] < n){
                prev[next[k]] = prev[k];
            }
            k = (next[k] < n) ? next[k] : prev[k];
        } else if(c == 'Z'){
            int r = stack.pop();
            status[r] = 'O';
            
            if(prev[r] >= 0) next[prev[r]] = r;
            if(next[r] < n) prev[next[r]] = r;
            
        }
    }
}
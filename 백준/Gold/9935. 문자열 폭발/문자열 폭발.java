import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        String pattern = br.readLine().trim();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<input.length(); i++){
            stack.push(input.charAt(i));
            if(pattern.length() == 1){
                if(stack.peek() == pattern.charAt(0)){
                    stack.pop();
                }
                continue;
            }
            if(stack.size()>=pattern.length()){
                boolean is = true;

                for(int j = stack.size()-1, count = pattern.length()-1; j>= stack.size()-pattern.length(); j--, count--){
                    if(stack.get(j) != pattern.charAt(count)){
                        is = false;
                        break;
                    }
                }

                if(is){
                    for(int j = 0; j<pattern.length(); j++){
                        stack.pop();
                    }
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()){
            System.out.println("FRULA");
        } else{
            for(Character c : stack){
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
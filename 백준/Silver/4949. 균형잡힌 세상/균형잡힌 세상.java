
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        while(!(s=br.readLine()).equals(".")){
            Boolean isOk = true;
            Stack<Character> stack = new Stack<Character>();
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(c == '[' || c == '('){
                    stack.push(c);
                }
                else if(c == ')'){
                    if(stack.isEmpty() || stack.pop() != '('){
                        isOk = false;
                        break;
                    }
                }
                else if(c == ']'){
                    if(stack.isEmpty() || stack.pop() != '['){
                        isOk = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()){
                isOk = false;
            }
            if(isOk == true){
                bw.write("yes\n");
            }
            else{
                bw.write("no\n");
            }
        }
        bw.flush();
    }
}


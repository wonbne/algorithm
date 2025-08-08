
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            int k = Integer.parseInt(br.readLine());
            if(k == 0){
                stack.pop();
            }
            else{
                stack.push(k);
            }
        }
        int sum = 0;
        for(int i = 0; i < stack.size(); i++){
            sum += stack.get(i);
        }
        bw.write(sum+"\n");
        bw.flush();
    }
}

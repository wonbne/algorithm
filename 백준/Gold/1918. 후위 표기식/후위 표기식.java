import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - 65 >= 0 && s.charAt(i) - 65 <= 90) {
                sb.append(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                while(stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
            } else if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(s.charAt(i))) {
                    sb.append(stack.pop());
                }
                stack.push(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    public static int priority(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        }
        return -1;
    }
}
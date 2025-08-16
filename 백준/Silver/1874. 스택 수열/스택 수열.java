
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        int count = 1;
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());

            while (count <= k) {
                st.push(count++);
                sb.append("+\n");
            }

            if (!st.isEmpty() && st.peek() == k) {
                st.pop();
                sb.append("-\n");
            } else {
                flag = false;
                for (int j = i + 1; j < n; j++) br.readLine();
                break;
            }
        }

        if (!flag) {
            bw.write("NO\n");
        } else {
            bw.write(sb.toString());
        }
        bw.flush();
    }
}

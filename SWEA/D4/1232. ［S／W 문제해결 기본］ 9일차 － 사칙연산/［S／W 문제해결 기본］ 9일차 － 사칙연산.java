import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public static class Node {
        int idx;
        char op;
        int left;
        int right;

        public Node(int idx, char op, int left, int right) {
            this.idx = idx;
            this.op = op;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            Stack<Node> stack = new Stack<>();
            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                String tmp = st.nextToken();
                char op = tmp.charAt(0);
                if (op == '-' || op == '+' || op == '*' || op == '/') {
                    int left = Integer.parseInt(st.nextToken());
                    int right = Integer.parseInt(st.nextToken());
                    Node node = new Node(idx, op, left, right);
                    stack.push(node);
                } else {
                    arr[idx] = Integer.parseInt(tmp);
                }
            }
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                char op = node.op;
                if (op == '-') {
                    arr[node.idx] = arr[node.left] - arr[node.right];
                } else if (op == '+') {
                    arr[node.idx] = arr[node.left] + arr[node.right];
                } else if (op == '*') {
                    arr[node.idx] = arr[node.left] * arr[node.right];
                } else if (op == '/') {
                    arr[node.idx] = arr[node.left] / arr[node.right];
                }
            }
            sb.append("#" + tc + " " + arr[1]);
            System.out.println(sb);
        }
    }
}
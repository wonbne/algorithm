import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
    public static class Node {
        char data;
        int self;
        int left;
        int right;

        Node(int self, char data, int left, int right) {
            this.self = self;
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            Node[] tree = new Node[n+1];
            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int self = Integer.parseInt(st.nextToken());
                char data = st.nextToken().charAt(0);
                int left = 0;
                int right = 0;
                if (st.hasMoreTokens()) {
                    left = Integer.parseInt(st.nextToken());
                }
                if (st.hasMoreTokens()) {
                    right = Integer.parseInt(st.nextToken());
                }
                Node node = new Node(self, data, left, right);
                tree[i] = node;
            }
            StringBuilder sb = new StringBuilder();
            inOrder(tree, 1, sb);
            System.out.println("#" + tc+ " " + sb);
        }
    }

    public static void inOrder(Node[] tree, int idx, StringBuilder sb){
        if(idx == 0){
            return ;
        }
        inOrder(tree, tree[idx].left, sb);//왼쪽 순회
        sb.append(tree[idx].data);
        inOrder(tree,tree[idx].right, sb);
    }
}
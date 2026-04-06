import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int op = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(op == 0){
                    union(a,b);
                } else if(op == 1){
                    if(find(a) == find(b)){
                        sb.append(1);
                    } else{
                        sb.append(0);
                    }
                }
            }
            System.out.println("#"+tc+" "+sb);
        }
    }

    public static void union(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);

        if (root1 != root2)
            parent[root1] = root2;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;

        int root = find(parent[x]);
        parent[x] = root;
        return root;
    }
}
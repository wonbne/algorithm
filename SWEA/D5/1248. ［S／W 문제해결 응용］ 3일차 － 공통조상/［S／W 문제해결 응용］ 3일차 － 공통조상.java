import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            count = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] parent = new int[v + 1];
            sb.append("#" + tc + " ");
            for (int i = 0; i < e; i++) {
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                parent[c] = p;
            }
            Set<Integer> comp = new HashSet<>();
            while (v1 != 1) {
                int tmp = parent[v1];
                comp.add(tmp);
                v1 = tmp;
            }
            int num = 0; // 가장 가까운 조상 번호
            while (v2 != 1) {
                int tmp = parent[v2];
                if (comp.contains(tmp)) {
                    sb.append(tmp+" ");
                    num = tmp;
                    break;
                }
                v2 = tmp;
            }
            dfs(parent, num);
            sb.append(count);
            System.out.println(sb);
        }
    }

    public static void dfs(int[] parent, int num) {
        for (int i = 1; i <= parent.length-1; i++) {
            if (parent[i] == num) {
                dfs(parent, i);
                count++;
            }
        }
    }

}
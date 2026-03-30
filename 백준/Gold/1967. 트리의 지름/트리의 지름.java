import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n,maxSum;
    static List<int[]>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        maxSum = 0;
        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int pIdx = Integer.parseInt(st.nextToken());
            int cIdx = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[pIdx].add(new int[] { cIdx, weight });
        }
        dfs(1);
        System.out.println(maxSum);
    }

    public static int dfs(int idx) {
        int max1 = 0;
        int max2 = 0;

        for(int[] next : tree[idx]){
            int child = next[0];
            int weight = next[1];

            int path = dfs(child) + weight;

            if(path>max1){
                max2 = max1;
                max1 = path;
            } else if(path>max2){
                max2 = path;
            }

            maxSum = Math.max(maxSum, max1+max2);
        }
        return max1;
    }


}
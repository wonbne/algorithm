import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int v, max;
    static List<int[]>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine().trim());
        tree = new ArrayList[v+1];
        visited = new boolean[v+1];
        for(int i = 0; i<=v; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 1; i<=v; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int idx = Integer.parseInt(st.nextToken());
            while(true){
                int next = Integer.parseInt(st.nextToken());
                if(next == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                tree[idx].add(new int[]{next, weight});
            }
        }
        visited[1] = true;
        dfs(1);
        System.out.println(max);
    }

    public static int dfs(int idx){
        int max1 = 0;
        int max2 = 0;
        for(int[] next : tree[idx]){
            int node = next[0];
            int weight = next[1];
            if(visited[node]) continue;
            visited[node] = true;
            int path = dfs(node) + weight;

            if(path>max1){
                max2 = max1;
                max1 = path;
            } else if(path>max2){
                max2 = path;
            }
            max = Math.max(max, max1 + max2);
        }
        return max1;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] parent;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        m = Integer.parseInt(br.readLine().trim());
        graph = new int[m+1][3];
        parent = new int[n+1];
        for(int i = 0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[i][0] = a;
            graph[i][1] = b;
            graph[i][2] = c;
        }
        for(int i = 1; i<=n; i++){
            parent[i] = i;
        }

        Arrays.sort(graph, (a,b) -> Integer.compare(a[2], b[2]));

        int sum = 0;
        for(int i = 1; i<=m; i++){
            if(find(graph[i][0]) != find(graph[i][1])){
                sum += graph[i][2];
                union(graph[i][0], graph[i][1]);
            }
        }
        System.out.println(sum);

    }

    public static void union(int a, int b){
        int n1 = find(a);
        int n2 = find(b);

        if(n1 != n2){
            parent[n1] = n2;
        }
    }

    public static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}
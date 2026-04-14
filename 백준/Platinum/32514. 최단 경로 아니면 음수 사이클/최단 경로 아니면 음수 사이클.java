import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, s;
    static int[] parent;
    static int INF = 987654321;
    static int[] dist;
    static List<int[]> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        dist = new int[n];
        parent = new int[n];
        Arrays.fill(dist, INF);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new int[]{a, b, c});
        }
        bellman();
    }

    public static void bellman() {
        dist[s] = 0;
        int x = -1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                int ed = edges.get(j)[1];
                int sta = edges.get(j)[0];
                int cost = edges.get(j)[2];

                if (dist[sta] != INF && dist[ed] > dist[sta] + cost)
                {
                    dist[ed] = dist[sta] + cost;
                    parent[ed] = sta;
                }
            }
        }
        for (int j = 0; j < m; j++) {
            int ed = edges.get(j)[1];
            int sta = edges.get(j)[0];
            int cost = edges.get(j)[2];

            if (dist[sta] != INF && dist[ed] > dist[sta] + cost)
            {
                parent[ed] = sta;
                x = ed;
            }
        }
        if(x == -1){
            System.out.println("PATH");
            for(int i : dist){
                System.out.print(i + " ");
            }
        } else{
            for(int i = 0; i<n; i++){
                x = parent[x];
            }
            int cur = x;
            List<Integer> cycle = new ArrayList<>();
            do{
                cycle.add(cur);
                cur = parent[cur];
            } while(cur != x);
            System.out.println("CYCLE");
            System.out.println(cycle.size());
            cycle.add(x);
            Collections.reverse(cycle);
            for(int i : cycle){
                System.out.print(i +" ");
            }
        }
    }
}
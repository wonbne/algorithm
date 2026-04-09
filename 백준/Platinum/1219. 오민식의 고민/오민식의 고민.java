import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, startN, endN, m;
    static Long[] dist;
    static int[] money;
    static List<Edge> edges;
    static List<Integer> cycle;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        startN = Integer.parseInt(st.nextToken());
        endN = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new Long[n];
        money = new int[n];
        edges = new ArrayList<>();
        cycle = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int sta = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            Long c = Long.parseLong(st.nextToken());
            edges.add(new Edge(sta, ed, -c));
        }
        st = new StringTokenizer(br.readLine().trim());
        for(int i =0 ; i<n; i++){
            money[i] = Integer.parseInt(st.nextToken());
        }
        bell();
        int ans = bfs();
        if(ans == -1){
            System.out.println("Gee");
        } else {
            if(dist[endN] == Long.MIN_VALUE){
                System.out.println("gg");
            } else{
                System.out.println(dist[endN]);
            }
        }
    }

    public static void bell(){
        Arrays.fill(dist, Long.MIN_VALUE);
        dist[startN] = (long) money[startN];

        for(int i = 0; i<n-1; i++){
            for(Edge e : edges){
                if(dist[e.start] != Long.MIN_VALUE && dist[e.end] < dist[e.start]+e.cost+money[e.end]){
                    dist[e.end] = dist[e.start]+ money[e.end]+e.cost ;

                }
            }
        }

        for(Edge e : edges){
            if(dist[e.start] != Long.MIN_VALUE && dist[e.end] < dist[e.start]+e.cost+money[e.end]){
                cycle.add(e.end);
            }
        }

    }

    static int bfs(){
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[n];
        for(int c : cycle){
            queue.add(c);
            visited[c] = true;
        }

        while(!queue.isEmpty()){
            int now = queue.poll();

            if(now == endN) return -1;

            for(Edge e : edges){
                if(e.start == now && !visited[e.end]){
                    visited[e.end] = true;
                    queue.add (e.end);
                }
            }
        }
        return 1;
    }
    static class Edge {
        int start;
        int end;
        Long cost;

        public Edge(int start, int end, Long cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
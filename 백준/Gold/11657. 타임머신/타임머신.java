import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static List<Edge> list;
    static long[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.add(new Edge(start, end, weight));
        }
        if(bellman() == -1){
            System.out.println(-1);
        } else{
            for(int i = 2; i<=n; i++){
                if(dist[i] == Long.MAX_VALUE){
                    System.out.println(-1);
                } else{
                    System.out.println(dist[i]);
                }
            }
        }
    }

    public static int bellman(){
        dist[1] = 0;
        for(int i = 1; i<n; i++){
            for(Edge e : list){
                if(dist[e.start] == Long.MAX_VALUE) continue;

                if(dist[e.end] > dist[e.start] + e.weight){
                    dist[e.end] = dist[e.start] + e.weight;
                }
            }
        }

        for(Edge e : list){
            if(dist[e.start] == Long.MAX_VALUE) continue;

            if(dist[e.end] > dist[e.start] + e.weight){
                return -1;
            }
        }
        return 1;
    }

    public static class Edge{
        int start;
        int end;
        int weight;
        public Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
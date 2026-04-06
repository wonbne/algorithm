import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, w;
    static List<Edge> edges;
    static int[] dist;

    static class Edge{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for(int tc = 1; tc<=t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            edges = new ArrayList<>();
            dist = new int[n+1];
            for(int i = 0; i<m; i++){
                st = new StringTokenizer(br.readLine().trim());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                edges.add(new Edge(s,e,time));
                edges.add(new Edge(e,s,time));
            }
            for(int i = 0; i<w; i++){
                st = new StringTokenizer(br.readLine().trim());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                edges.add(new Edge(s,e,-time));
            }
            if(bellman()){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean bellman() {
        Arrays.fill(dist, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < edges.size(); j++) {
                Edge edge = edges.get(j);

                if (dist[edge.end] > dist[edge.start] + edge.weight) {
                    dist[edge.end] = dist[edge.start] + edge.weight;
                }
            }
        }

        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);

            if (dist[edge.end] > dist[edge.start] + edge.weight) {
                return true;
            }
        }
        return false;
    }
}
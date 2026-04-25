import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static long INF = Long.MAX_VALUE;
    static long[] dist, point;
    static List<int[]>[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new long[n];
        Arrays.fill(dist,INF);
        point = new long[n];
        edges = new ArrayList[n];
        for(int i = 0; i<n; i++){
            edges[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i<n; i++){
            point[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if ((point[a] == 1 && a != n - 1) || (point[b] == 1 && b != n - 1)) continue;

            edges[a].add(new int[]{b,t});
            edges[b].add(new int[]{a,t});
        }
        dij();
        if (dist[n - 1] == INF) System.out.println("-1");
        else System.out.println(dist[n - 1]);


    }

    public static void dij(){
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[1], b[1]));
        pq.add(new long[]{0, 0}); //idx,time
        dist[0] = 0;
        while(!pq.isEmpty()){
            long[] tmp = pq.poll();
            int idx = (int) tmp[0];
            long time = tmp[1];

            if(time > dist[idx]) continue;

            for(int[] next : edges[idx]){
                if(dist[next[0]] > dist[idx] + next[1]){
                    dist[next[0]] = dist[idx] + next[1];
                    pq.add(new long[]{next[0], dist[next[0]]});
                }
            }

        }
    }
}
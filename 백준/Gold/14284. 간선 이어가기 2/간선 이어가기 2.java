import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m,s,t,min;
    static List<int[]>[] edges;
    static int[] dist;
    static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new ArrayList[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        for(int i = 0; i<=n; i++){
            edges[i] = new ArrayList<>();
        }
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[start].add(new int[]{end, c});
            edges[end].add(new int[]{start,c});
        }
        st = new StringTokenizer(br.readLine().trim());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        dij();
        System.out.println(dist[t]);
    }

    public static void dij(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        pq.add(new int[]{s,0});
        dist[s] = 0;
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            int now = tmp[0];
            int c = tmp[1];
            for(int[] next : edges[now]){
                int nextNode = next[0];
                int nextCost = next[1];

                if(dist[nextNode] > dist[now] + nextCost){
                    dist[nextNode] = dist[now] + nextCost;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
    }
}
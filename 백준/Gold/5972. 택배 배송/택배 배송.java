import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[] dist;
    static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        graph = new ArrayList[n+1];
        for(int i = 0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine().trim());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[s].add(new int[]{e,c});
            graph[e].add(new int[]{s,c});
        }
        dij();
        System.out.println(dist[n]);
    }

    public static void dij(){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));
        queue.add(new int[]{1,0});
        dist[1] = 0;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int now = tmp[0];

            for(int[] next : graph[now]){
                int nextN = next[0];
                int nextCost = next[1];
                if(dist[nextN] > dist[now] + nextCost){
                    dist[nextN] = dist[now] + nextCost;
                    queue.add(new int[]{nextN, dist[nextN]});
                }
            }

        }
    }
}
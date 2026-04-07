import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m,x,max;
    static int[] dist;
    static List<int[]>[] edges, reverse;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        max = 0;
        dist = new int[n + 1];
        edges = new ArrayList[n + 1];
        reverse = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[start].add(new int[]{end, weight});
            reverse[end].add(new int[]{start, weight});
        }
        dij(x, edges);
        int[] ans1 = Arrays.copyOf(dist, dist.length);
        dij(x, reverse);
        int[] ans2 = Arrays.copyOf(dist, dist.length);
        for(int i = 1; i<=n; i++){
            max = Math.max(max, ans1[i]+ans2[i]);
        }
        System.out.println(max);
    }

    public static void dij(int start, List<int[]>[] t){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        queue.add(new int[]{start, 0});
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int s = tmp[0];
            int w = tmp[1];

            if(dist[s] < w) continue;

            for(int[] next : t[s]){
                if(dist[next[0]]> dist[s]+next[1]){
                    dist[next[0]] = dist[s]+next[1];
                    queue.add(new int[]{next[0], dist[next[0]]});
                }
            }

        }

    }

}
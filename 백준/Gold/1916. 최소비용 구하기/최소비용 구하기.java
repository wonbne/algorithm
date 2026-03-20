import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] dist;
    static List<int[]>[] city;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        m = Integer.parseInt(br.readLine().trim());
        city = new ArrayList[n + 1];
        dist = new int[n + 1];
        for(int i = 0; i<=n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= n; i++) {
            city[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            city[start].add(new int[]{end, val});
        }
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dij(start);
        System.out.println(dist[end]);
    }

    public static void dij(int start){
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(o->o[1]));
        queue.add(new int[]{start, 0});
        dist[start] = 0;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int now = tmp[0];
            int val = tmp[1];
            if(val>dist[now]) continue;
            for(int i = 0; i<city[now].size(); i++){
                int next = city[now].get(i)[0];
                int nVal = city[now].get(i)[1];
                if(dist[next]>nVal + val){
                    dist[next] = nVal + val;
                    queue.add(new int[]{next, dist[next]});
                }
            }
        }

    }
}

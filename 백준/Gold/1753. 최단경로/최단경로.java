import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int v, e, k;
    static List<int[]>[] list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine().trim());
        list = new ArrayList[v + 1];
        dist = new int[v+1];
        for(int i = 0; i<=v; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= v; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int tmpU = Integer.parseInt(st.nextToken());
            int tmpV = Integer.parseInt(st.nextToken());
            int tmpW = Integer.parseInt(st.nextToken());
            list[tmpU].add(new int[] { tmpV, tmpW });
        }
        bfs();
        dist[k] = 0;
        for(int i = 1; i<=v; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            } else{
                System.out.println(dist[i]);
            }
        }
    }

    static void bfs() {

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(o->o[1]));
        queue.offer(new int[]{k,0});
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int now = tmp[0];
            int val = tmp[1];
            if (dist[now] < val) {
                continue;
            }
            for (int i = 0; i < list[now].size(); i++) {
                int nextN = list[now].get(i)[0];
                int nextV = list[now].get(i)[1] + val;

                if(nextV < dist[nextN]){
                    dist[nextN] = nextV;
                    queue.offer(new int[]{nextN, nextV});
                }
            }
        }
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, e;
    static List<int[]>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        if (e == 0) {
            System.out.println(-1);
            return;
        }

        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[end].add(new int[] { start, cost });
            list[start].add(new int[] { end, cost });
        }

        st = new StringTokenizer(br.readLine().trim());
        int mNode1 = Integer.parseInt(st.nextToken());
        int mNode2 = Integer.parseInt(st.nextToken());
        int[] dist1 = dij(1);
        int[] dist2 = dij(mNode1);
        int[] dist3 = dij(mNode2);

        long path1 = (long)dist1[mNode1] + dist2[mNode2] + dist3[n];
        long path2 = (long)dist1[mNode2] + dist3[mNode1] + dist2[n];


        long result = Math.min(path1, path2);
        System.out.println(result >= Integer.MAX_VALUE ? -1 : result);
    }

    public static int[] dij(int start) {
        int[] dist = new int[n+1];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        queue.offer(new int[] { start, 0 });
        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int val = cur[1];

            if (val > dist[node])
                continue;
            for (int[] next : list[node]) {
                int nextNode = next[0];
                int nextCost = next[1];

                if (dist[nextNode] > dist[node] + nextCost) {
                    dist[nextNode] = dist[node] + nextCost;
                    queue.offer(new int[] { nextNode, dist[nextNode] });
                }
            }

        }
        return dist;
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, startIdx, endIdx;
    static int[] dist;
    static List<int[]>[] edges;
    static List<Integer> path;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        m = Integer.parseInt(br.readLine().trim());
        dist = new int[n + 1];
        edges = new ArrayList[n + 1];
        path = new ArrayList<>();
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[start].add(new int[] { end, weight });
        }
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        startIdx = Integer.parseInt(st.nextToken());
        endIdx = Integer.parseInt(st.nextToken());
        dij();
        int curr = endIdx;
        while(curr != 0){
            path.add(curr);
            curr = parent[curr];
        }
        System.out.println(dist[endIdx] + "\n" + path.size());
        for (int i = path.size()-1; i>=0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }

    public static void dij() {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[startIdx] = 0;
        queue.add(new int[] { startIdx, 0 });

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int node = tmp[0];
            int weight = tmp[1];
            if (weight > dist[node])
                continue;

            for (int[] next : edges[node]) {
                if (dist[next[0]] > dist[node] + next[1]) {
                    dist[next[0]] = dist[node] + next[1];
                    parent[next[0]] = node;
                    queue.add(new int[] { next[0], dist[next[0]] });
                }
            }

        }

    }
}
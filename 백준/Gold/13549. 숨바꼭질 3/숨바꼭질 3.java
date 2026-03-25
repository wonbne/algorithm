import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] dist;
    static int size = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dist = new int[size + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dij();
        System.out.println(dist[k]);
    }

    public static void dij() {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        queue.offer(new int[] { n, 0 });
        dist[n] = 0;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int now = tmp[0];
            int sec = tmp[1];

            if (now + 1 <= size && dist[now + 1] > sec + 1) {
                dist[now + 1] = sec + 1;
                queue.offer(new int[] { now + 1, sec + 1 });
            }
            if (now - 1 >= 0 && dist[now - 1] > sec + 1) {
                dist[now - 1] = sec + 1;
                queue.offer(new int[] { now - 1, sec + 1 });
            }
            if (2 * now <= size && dist[now * 2] > sec) {
                dist[now * 2] = sec;
                queue.offer(new int[] { 2 * now, sec });
            }

        }
    }
}

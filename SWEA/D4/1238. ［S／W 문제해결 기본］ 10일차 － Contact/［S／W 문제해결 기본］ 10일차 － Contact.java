import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int n, s, answer;
    static List<Integer>[] edges;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            answer = 0;
            edges = new ArrayList[101];
            visited = new boolean[101];
            for (int i = 0; i <= 100; i++) {
                edges[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < n/2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                edges[from].add(to);
            }
            check();
            System.out.println("#" + tc + " " + answer);
        }
    }

    public static void check() {
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = 0;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                max = Math.max(cur, max);
                for (int next : edges[cur]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            answer = max;
        }
    }

}
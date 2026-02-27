import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int v;
    static int e;
    static List<List<Integer>> graph;
    static int[] indegree;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            indegree = new int[v + 1];
            answer = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                graph.add(new ArrayList<>());
            }
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < e; i++) {
                int pre = Integer.parseInt(st.nextToken());
                int now = Integer.parseInt(st.nextToken());
                graph.get(pre).add(now);
                indegree[now]++;
            }

            bfs();
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");
            for (int ans : answer) {
                sb.append(ans + " ");
            }
            System.out.println(sb);
        }
    }

    public static void bfs() {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= v; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            answer.add(tmp);

            for (int next : graph.get(tmp)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

    }

}
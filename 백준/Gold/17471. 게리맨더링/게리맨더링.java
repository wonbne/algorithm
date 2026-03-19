import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, min;
    static int[] people;
    static boolean[] select;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        people = new int[n + 1];
        select = new boolean[n + 1];
        list = new ArrayList[n + 1];
        min = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 1; i <= n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int t = Integer.parseInt(st.nextToken());
                list[i].add(t);
            }
        }
        dfs(1);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void dfs(int idx) {
        if (idx == n + 1) {
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (select[i] == true) {
                    cnt++;
                }
            }
            boolean is = true;
            for (int i = 1; i <= n; i++) {
                if (select[i] == true) {
                    if (bfs(i, true) != cnt) {
                        is = false;
                        break;
                    }
                } else{
                    if(bfs(i, false) != (n-cnt)){
                        is = false;
                        break;
                    }
                }
            }

            int sum1 = 0, sum2 = 0;
            if (is) {
                for (int i = 1; i <= n; i++) {
                    if (select[i] == true) {
                        sum1 += people[i];
                    } else {
                        sum2 += people[i];
                    }
                }
                min = Math.min(min, Math.abs(sum1 - sum2));

            }
            return;
        }

        select[idx] = true;
        dfs(idx + 1);
        select[idx] = false;
        dfs(idx + 1);
    }

    public static int bfs(int x, boolean is) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        boolean[] visited = new boolean[n + 1];
        visited[x] = true;
        int cnt = 1;
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int next : list[tmp]) {
                if (!visited[next] && select[next] == is) {
                    visited[next] = true;
                    queue.offer(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

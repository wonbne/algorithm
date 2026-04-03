import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] list;
    static int[] indegree, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        indegree = new int[n + 1];
        count = new int[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            list[before].add(after);

            indegree[after]++;
        }
        sort();
        for(int i = 1; i<=n; i++){
            System.out.print(count[i]+1 + " ");
        }
    }

    public static void sort() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int i = 0; i < list[tmp].size(); i++) {
                int t = list[tmp].get(i);
                indegree[t]--;
                count[t] = Math.max(count[t], count[tmp]+1);
                if(indegree[t] == 0){
                    queue.add(t);
                }
            }
        }

    }

}
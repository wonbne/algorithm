import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        dfs(1, 0);
    }

    public static void dfs(int start, int count) {
        if (count == m) {
            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }

        for (int i = start; i <= n; i++) {
            visited[i] = true;
            dfs(i + 1, count + 1);
            visited[i] = false;
        }
    }

}
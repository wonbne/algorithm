
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] g;
    static boolean[] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        g = new boolean[n+1][n+1];
        visited = new boolean[n+1];

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a][b] = g[b][a] = true;
        }

        dfs(1);
        int count = 0;
        for(int i = 2; i<=n; i++){
            if (visited[i]) count++;
        }
        bw.write(count + "\n");
        bw.flush();
    }

    static void dfs(int v){
        visited[v] = true;
        for(int i = 1; i<=n; i++){
            if(g[v][i] && !visited[i]){
                dfs(i);
            }
        }
    }
}

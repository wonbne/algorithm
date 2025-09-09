
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n;
    static int m;
    static int v;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i = 1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }
        dfs(v);
        bw.newLine();

        Arrays.fill(visited, false);
        bfs(v);
        bw.flush();
    }
    public static void dfs(int node) throws IOException{
        visited[node] = true;
        bw.write(node + " ");
        for(int i=1; i<=n; i++){
            if(!visited[i] && arr[node][i] == 1){
                dfs(i);
            }
        }
    }

    public static void bfs(int node) throws IOException{
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.offer(node);
        while(!q.isEmpty()){
            int cur = q.poll();
            bw.write(cur + " ");
            for(int i = 1; i<=n; i++){
                if(!visited[i] && arr[cur][i] == 1){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }

    }
}

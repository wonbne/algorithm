
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i = 1; i<m+1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }
        for(int i = 1; i<n+1; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
    public static void dfs(int node){
        visited[node] = true;

        for(int i = 1; i<n+1; i++){
            if(!visited[i] && arr[node][i] == 1){
                dfs(i);
            }
        }
    }
}

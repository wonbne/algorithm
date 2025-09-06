import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] arr = new int[M][N];
            for(int i = 0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }
            int count = 0;
            for(int i = 0; i<M; i++) {
                for(int j = 0; j<N; j++) {
                    if(arr[i][j] == 1) {
                        dfs(i, j, arr, M, N);
                        count++;
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
    }
    static void dfs(int x, int y, int[][] arr, int M, int N) {
        arr[x][y] = 0;
        if (x - 1 >= 0 && arr[x - 1][y] == 1) {
            dfs(x - 1, y, arr, M, N);
        }
        if (x + 1 < M && arr[x + 1][y] == 1) {
            dfs(x + 1, y, arr, M, N);
        }
        if (y - 1 >= 0 && arr[x][y - 1] == 1) {
            dfs(x, y - 1, arr, M, N);
        }
        if (y + 1 < N && arr[x][y + 1] == 1) {
            dfs(x, y + 1, arr, M, N);
        }
    }

}

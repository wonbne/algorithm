import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[][] arr;
    static int n, max;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        max = 0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i<= n; i++){
            for(int j = 1; j<=n; j++){
                bomb(i,j, arr[i][j]);
            }
        }

        System.out.println(max);

    }

    public static void bomb(int x, int y, int size){
        int[][] tmp = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                tmp[i][j] = arr[i][j];
            }
        }

        for(int d = 0; d<4; d++){
            for(int i = 0; i<size; i++){
                int nx = x + dx[d]*i;
                int ny = y + dy[d]*i;
                if(nx<=0 || ny <=0 || nx>n || ny >n) continue;
                tmp[nx][ny] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            int idx = n;
            for (int j = n; j >= 1; j--) {
                if (tmp[j][i] != 0) {
                    tmp[idx][i] = tmp[j][i];
                    idx--;
                }
            }
            for (int j = 1; j <= idx; j++) {
                tmp[j][i] = 0;
            }
        }

        find(tmp);
    }

    public static void find(int[][] tmp){
        int count = 0;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                for(int d = 0; d<4; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if(nx <=0 || ny <= 0 || nx>n || ny > n ) continue;

                    if(tmp[i][j] != 0 && tmp[nx][ny] == tmp[i][j]) count++;
                }
            }
        }
        max = Math.max(count/2, max);
    }

}
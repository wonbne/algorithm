import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[][] arr;
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i = 0; i<m; i++){
            int col = Integer.parseInt(br.readLine().trim());
            int top = find(col);
            if(top == -1) continue;
            bomb(top, col, arr[top][col]);
            move();
        }

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int find(int col) {
        for(int i = 1; i<=n; i++){
            if(arr[i][col] != 0){
                return i;
            }
        }
        return -1;
    }

    public static void bomb(int x, int y, int size){
        for(int d = 0; d<4; d++){
            for(int i = 0; i<size; i++){
                int nx = x + dx[d]*i;
                int ny = y + dy[d]*i;
                if(nx<=0 || ny <=0 || nx>n || ny >n) continue;
                arr[nx][ny] = 0;
            }
        }
    }

    public static void move() {

        for (int i = 1; i <= n; i++) {
            int idx = n;
            for (int j = n; j >= 1; j--) {
                if (arr[j][i] != 0) {
                    arr[idx][i] = arr[j][i];
                    idx--;
                }
            }
            for (int j = 1; j <= idx; j++) {
                arr[j][i] = 0;
            }
        }

    }
}
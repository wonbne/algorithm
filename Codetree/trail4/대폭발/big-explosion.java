import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n, m, r, c;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        int count = 0;
        arr[r][c] = 1;

        for(int i = 1; i<=m; i++){
            bomb(i);
        }
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(arr[i][j] == 1){
                    count++;
                }
            }
        }

        System.out.println(count);


    }

    public static void bomb(int time){
        int[][] temp = new int[n+1][n+1];

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                temp[i][j] = arr[i][j];
            }
        }
        for(int i = 1; i<= n; i++){
            for(int j = 1; j<=n; j++){
                if(arr[i][j] == 1){
                    for(int d = 0; d<4; d++){
                        int nx = i + dx[d]*(int)Math.pow(2, time-1);
                        int ny = j + dy[d]*(int)Math.pow(2, time-1);

                        if(nx <= 0 || ny <= 0 || nx>n || ny > n) continue;
                        temp[nx][ny] = 1;
                    }
                }
            }
        }

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                arr[i][j] = temp[i][j];
            }
        }

    }
}
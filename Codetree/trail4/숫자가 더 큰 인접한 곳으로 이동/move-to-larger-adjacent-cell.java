import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int[][] arr;
    static int n,r,c;
    static List<Integer> list;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list = new ArrayList<>();

        list.add(arr[r][c]);

        while(true){
            int nr = r;
            int nc = c;
            move();
            if(nr == r && nc == c) break;
        }

        for(int i : list){
            System.out.print(i + " ");
        }

    }

    public static void move(){
        for(int d = 0; d<4; d++){
            int nx = r + dx[d];
            int ny = c + dy[d];
            if(nx >n || ny >n || nx<=0 || ny<= 0) continue;
            if(arr[r][c] < arr[nx][ny]){
                r = nx;
                c = ny;
                list.add(arr[nx][ny]);
                break;
            }
        }
    }


}
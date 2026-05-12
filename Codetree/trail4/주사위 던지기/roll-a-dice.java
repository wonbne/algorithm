import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n, m, r, c;
    static int[] dice = {1,6,5,2,3,4};
    static final int TOP = 0;
    static final int BOTTOM = 1;
    static final int NORTH = 2;
    static final int SOUTH = 3;
    static final int EAST = 4;
    static final int WEST = 5;
    // 1 6 5 2 3 4

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        int count = 0;
        arr[r][c] = dice[BOTTOM];

        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i<m; i++){
            char dir = st.nextToken().charAt(0);
            if(dir == 'L'){
                c -= 1;
                if(c <= 0){
                    c+=1;
                    continue;
                }
                move(dir);
            } else if(dir == 'R'){
                c += 1;
                if(c > n){
                    c-=1;
                    continue;
                }
                move(dir);
            } else if(dir == 'U'){
                r -= 1;
                if(r <= 0){
                    r+=1;
                    continue;
                }
                move(dir);
            } else if(dir == 'D'){
                r += 1;
                if(r > n){
                    r-=1;
                    continue;
                }
                move(dir);
            }
        }
        for(int i =1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                count+=arr[i][j];
            }
        }
        System.out.println(count);
    }

    public static void move(char dir){
        if(dir == 'L'){
            int tmp = dice[TOP];
            dice[TOP] = dice[EAST];
            dice[EAST] = dice[BOTTOM];
            dice[BOTTOM] = dice[WEST];
            dice[WEST] = tmp;
            arr[r][c] = dice[BOTTOM];
        } else if(dir == 'R'){
            int tmp = dice[TOP];
            dice[TOP] = dice[WEST];
            dice[WEST] = dice[BOTTOM];
            dice[BOTTOM] = dice[EAST];
            dice[EAST] = tmp;
            arr[r][c] = dice[BOTTOM];
        } else if(dir == 'U'){
            int tmp = dice[TOP];
            dice[TOP] = dice[SOUTH];
            dice[SOUTH] = dice[BOTTOM];
            dice[BOTTOM] = dice[NORTH];
            dice[NORTH] = tmp;
            arr[r][c] = dice[BOTTOM];
        } else if(dir == 'D'){
            int tmp = dice[TOP];
            dice[TOP] = dice[NORTH];
            dice[NORTH] = dice[BOTTOM];
            dice[BOTTOM] = dice[SOUTH];
            dice[SOUTH] = tmp;
            arr[r][c] = dice[BOTTOM];
        }
    }
}
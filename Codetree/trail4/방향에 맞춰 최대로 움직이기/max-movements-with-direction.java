import java.util.Scanner;
public class Main {

    static int n;
    static int[][] num, moveDir;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        moveDir = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                moveDir[i][j] = sc.nextInt()-1;
            }
        }
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        // Please write your code here.
        System.out.println(dfs(r,c));

    }

    public static int dfs(int r, int c){
        int countMax = 0;
        int dir = moveDir[r][c];
        int cur = num[r][c];

        int nr = r;
        int nc = c;

        while(true){
            nr += dx[dir];
            nc += dy[dir]; 
            if(nr >= n || nr < 0 || nc >= n || nc < 0 ){
                break;
            }

            if(num[nr][nc] > cur){
                countMax = Math.max(countMax, dfs(nr, nc)+1);
            }
        }
        return countMax;

    }
}
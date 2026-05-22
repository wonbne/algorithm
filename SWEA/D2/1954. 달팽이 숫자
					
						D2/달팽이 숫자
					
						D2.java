import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            int N = sc.nextInt();

            int[][] arr = new int[N][N];

            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            int dir = 0;

            int x = 0;
            int y = 0;

            for (int num = 1; num <= N * N; num++) {

                arr[x][y] = num;

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] != 0) {

                    dir = (dir + 1) % 4;

                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }

                x = nx;
                y = ny;
            }

            System.out.println("#" + tc);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
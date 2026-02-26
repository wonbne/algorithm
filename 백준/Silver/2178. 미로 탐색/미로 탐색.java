import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static boolean visited[][];
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String a = sc.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = a.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        int ans = arr[n - 1][m - 1];
        System.out.println(ans);

    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[] { x, y });
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int curX = tmp[0];
            int curY = tmp[1];
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && arr[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[] { nx, ny });
                    arr[nx][ny] = arr[curX][curY] + 1;
                }
            }
        }
    }
}

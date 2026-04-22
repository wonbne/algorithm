import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
    static int n;
    static int INF = 987654321;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine().trim());
            map = new int[n][n];
            dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = INF;
                }
            }
            for (int i = 0; i < n; i++) {
                String s = br.readLine().trim();
                for (int j = 0; j < n; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }

            dij();
            System.out.println("#" + tc + " " + dist[n - 1][n - 1]);
        }
    }

    public static void dij() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[]{0, 0, 0});
        dist[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int x = tmp[0];
            int y = tmp[1];

            if (x == n - 1 && y == n - 1) continue;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if (dist[nx][ny] > dist[x][y] + map[nx][ny]) {
                    dist[nx][ny] = dist[x][y] + map[nx][ny];
                    pq.add(new int[]{nx, ny, dist[nx][ny]});
                }

            }
        }
    }

}
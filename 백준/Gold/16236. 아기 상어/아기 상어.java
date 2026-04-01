import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] map;
    static int n, startX, startY, max;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        visited = new boolean[n][n];
        map = new int[n][n];
        max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    startX = i;
                    startY = j;
                    map[i][j] = 0;
                }
            }
        }
        bfs();
        System.out.println(max);
    }

    public static void bfs() {

        int size = 2;
        int eat = 0;
        while (true) {
            boolean check = false;

            visited = new boolean[n][n];
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] != o2[2] ? Integer.compare(o1[2], o2[2])
                    : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1])));
            visited[startX][startY] = true;
            queue.add(new int[] { startX, startY, 0 });
            while (!queue.isEmpty()) {
                int[] tmp = queue.poll();
                int x = tmp[0];
                int y = tmp[1];
                int time = tmp[2];

                if (map[x][y] != 0 && map[x][y] < size) {
                    eat++;
                    map[x][y] = 0;
                    startX = x;
                    startY = y;
                    max += time;
                    check = true;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx >= n || ny >= n || nx < 0 || ny < 0 || map[nx][ny] > size || visited[nx][ny])
                        continue;
                    visited[nx][ny] = true;
                    queue.add(new int[] { nx, ny, time + 1 });
                }
            }
            if (!check) {
                break;
            }

            if (eat == size) {
                eat = 0;
                size++;
            }
        }

    }
}
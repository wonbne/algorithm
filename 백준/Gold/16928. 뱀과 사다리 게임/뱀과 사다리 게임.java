import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] ladder;
    static int[][] snake;
    static int min;
    static int n, m;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ladder = new int[n][2];
        snake = new int[m][2];
        min = Integer.MAX_VALUE;
        visited = new boolean[101];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladder[i][0] = x;
            ladder[i][1] = y;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            snake[i][0] = x;
            snake[i][1] = y;
        }
        bfs();
        System.out.println(min);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 1, 0 });
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int idx = tmp[0];
            int count = tmp[1];
            visited[idx] = true;

            if (idx == 100) {
                min = Math.min(min, count);
                continue;
            }
            if (count > min) {
                continue;
            }

            for (int i = 1; i <= 6; i++) {
                if (idx+i<=100 && !visited[idx + i]) {
                    boolean is = false;
                    for (int j = 0; j < n; j++) {
                        if (idx + i == ladder[j][0]) {
                            queue.offer(new int[] { ladder[j][1], count + 1 });
                            is = true;
                            break;
                        }
                    }
                    for (int j = 0; j < m; j++) {
                        if (idx + i == snake[j][0]) {
                            queue.offer(new int[] { snake[j][1], count + 1 });
                            is = true;
                            break;
                        }
                    }

                    if (is) {
                        continue;
                    } else {
                        queue.offer(new int[] { idx + i, count + 1 });
                    }
                }

            }
        }
    }
}

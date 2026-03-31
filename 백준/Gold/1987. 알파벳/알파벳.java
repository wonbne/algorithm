import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c, max;
    static char[][] arr;
    static boolean[] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        visited = new boolean[26];
        max = 0;
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        visited[arr[0][0] - 65] = true;
        dfs(0,0,1);
        System.out.println(max);
    }

    public static void dfs(int x, int y, int count) {
        boolean is = false;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= r || ny >= c || nx < 0 || ny < 0 || visited[arr[nx][ny] - 65]) {
                continue;
            }

            visited[arr[nx][ny] - 65] = true;
            dfs(nx, ny, count + 1);
            visited[arr[nx][ny] - 65] = false;
            is = true;
        }
        if(!is){
            max = Math.max(count, max);
            return;
        }
    }
}
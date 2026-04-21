import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int n, m, max;
    static int[][] city;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            city = new int[n][n];
            max = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < n; j++) {
                    city[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    bfs(i, j);
                }
            }
            System.out.println("#"+tc+" "+max);
        }
    }

    public static void bfs(int tx, int ty) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.add(new int[]{tx, ty});
        visited[tx][ty] = true;
        int count = 0;
        int k = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for(int s = 0; s<size; s++){
                int[] tmp = q.poll();
                int x = tmp[0];
                int y = tmp[1];
                if(city[x][y] == 1) count++;

                for(int d = 0; d<4; d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(nx < 0 || ny < 0 || nx>=n || ny >=n || visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
            int cal = k*k + (k-1) * (k-1);
            if(m*count>=cal){
                max = Math.max(count, max);
            }
            k++;
        }

    }
}
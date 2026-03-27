import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, cnt, sum;
    static int[][] arr;
    static boolean[] visited;
    static List<chicken> cArr;

    public static class chicken {
        int x, y;

        public chicken(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        cnt = 0;
        sum = Integer.MAX_VALUE;
        cArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    cnt++;
                    cArr.add(new chicken(i, j));
                }
            }
        }
        visited = new boolean[cnt];

        dfs(0,0);

        System.out.println(sum);
    }

    public static void dfs(int start, int count) {
        if (count == m) {
            int nSum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 1) {
                        int min = Integer.MAX_VALUE;
                        for (int k = 0; k < cnt; k++) {
                            if(visited[k]){
                                min = Math.min(Math.abs(i-cArr.get(k).x) + Math.abs(j - cArr.get(k).y), min);
                            }
                        }
                        nSum += min;
                    }
                }
            }
            sum = Math.min(nSum,sum);
            return;
        }
        for (int i = start; i < cnt; i++) {
            visited[i] = true;
            dfs(i + 1, count + 1);
            visited[i] = false;
        }
    }
}
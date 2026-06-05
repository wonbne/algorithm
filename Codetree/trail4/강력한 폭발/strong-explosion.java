import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][][] dir = {
            {{-2,0}, {-1,0}, {0,0}, {1,0}, {2,0}},
            {{-1,0}, {1,0}, {0,-1}, {0,0}, {0,1}},
            {{-1,-1}, {-1,1}, {0,0}, {1,-1}, {1,1}}};
    static int[][] cnt;
    static int n;
    static int total;
    static int[][] location;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cnt = new int[n][n];
        total = 0;
        size = 0;
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                int t = Integer.parseInt(st.nextToken());
                if(t == 1){
                    cnt[i][j]++;
                    size++;
                }
            }
        }

        location = new int[size][2];

        int idx = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(cnt[i][j] == 1){
                    location[idx][0] = i;
                    location[idx++][1] = j;
                }
            }
        }

        dfs(0);

        System.out.println(total);
    }

    public static void dfs(int depth) {
        if (depth == size) {
            int tmpTotal = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cnt[i][j] > 0) {
                        tmpTotal++;
                    }
                }
            }
            total = Math.max(total, tmpTotal);
            return;
        }

        int x = location[depth][0];
        int y = location[depth][1];


        for(int t = 0; t<3; t++){
            for(int[] d : dir[t]){
                int nx = x + d[0];
                int ny = y + d[1];
                if(nx < 0 || ny <0 || nx >= n || ny >= n) continue;

                cnt[nx][ny]++;
            }
            dfs(depth+1);

            for(int[] d : dir[t]){
                int nx = x + d[0];
                int ny = y + d[1];
                if(nx < 0 || ny <0 || nx >= n || ny >= n) continue;

                cnt[nx][ny]--;
            }
        }
    }
}

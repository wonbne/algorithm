import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int d, w, k, min;
    static int[][] film;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            film = new int[d][w];
            min = Integer.MAX_VALUE;
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < w; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0,0);
            System.out.println("#"+tc+" "+min);
        }

    }


    public static void dfs(int count, int idx) {
        if(idx == d){
            if(check()){
                min = Math.min(min, count);
            }
            return ;
        }

        if(count >= min) return;
        // a : 0, b : 1
        int[] tmp = film[idx].clone();
        modify(idx, 0);
        dfs(count+1, idx+1);
        film[idx] = tmp.clone();

        modify(idx, 1);
        dfs(count +1, idx+1);
        film[idx] = tmp.clone();

        dfs(count, idx+1);

    }

    public static boolean check() {

        for(int i = 0; i<w; i++){
            int count = 1;
            int kind = 0;
            for(int j = 0; j<d; j++){
                if(j == 0){
                    kind = film[j][i];
                    continue;
                }

                if(film[j][i] == 0 && kind == 0){
                    count++;
                } else if(film[j][i] == 1 && kind == 1){
                    count++;
                } else{
                    count = 1;
                    kind = film[j][i];
                }

                if(count >= k) break;
            }
            if(count<k) return false;
        }
        return true;
    }

    public static void modify(int x, int kind){
        for(int i = 0; i<w; i++){
            film[x][i] = kind;
        }
    }
}
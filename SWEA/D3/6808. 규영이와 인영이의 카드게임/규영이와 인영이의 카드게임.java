import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] gyu;
    static boolean[] visited;
    static int win, lose;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            gyu = new int[9];
            visited = new boolean[19];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < 9; i++) {
                gyu[i] = Integer.parseInt(st.nextToken());
                visited[gyu[i]] = true;
            }
            win = 0;
            lose = 0;
            dfs(0, 0, 0);
            System.out.println("#" + tc + " " + win + " " + lose);
        }
    }

    static void dfs(int idx, int gPoint, int iPoint) {
        if (idx == 9) {
            if (gPoint > iPoint) {
                win++;
            } else if (gPoint < iPoint) {
                lose++;
            }
            return;
        }
        for (int i = 1; i <= 18; i++) {
            if (!visited[i]) {
                if (gyu[idx] > i) {
                    visited[i] = true;
                    dfs(idx + 1, gPoint + gyu[idx] + i, iPoint);
                    visited[i] = false;
                } else if (gyu[idx] < i) {
                    visited[i] = true;
                    dfs(idx + 1, gPoint, iPoint + gyu[idx] + i);
                    visited[i] = false;
                }
            }
        }
    }
}

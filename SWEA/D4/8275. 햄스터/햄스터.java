import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int n, x, m, max;
    static int[] hamNum;
    static int[][] info;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            hamNum = new int[n + 1];
            info = new int[m + 1][3];
            max = -1;
            ans = null;
            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                info[i][0] = l;
                info[i][1] = r;
                info[i][2] = s;
            }
            dfs(1, 0);
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");
            if (ans == null) {
                sb.append(-1);
            } else {
                for (int i = 1; i <= n; i++) {
                    sb.append(ans[i] + " ");
                }
            }
            System.out.println(sb);
        }
    }

    public static void dfs(int seq, int sum) {
        if (seq == n + 1) {
            if (check()) {
                if (sum > max) {
                    max = sum;
                    ans = hamNum.clone();
                }
            }

            return;
        }

        for (int i = 0; i <= x; i++) {
            hamNum[seq] = i;
            dfs(seq + 1, sum + i);
        }
        // hamNum[seq] += 1;
        // dfs(seq, sum + 1);
        // hamNum[seq] -= 1;
        // dfs(seq + 1, sum);
    }

    public static boolean check() {
        boolean is = true;
        for (int i = 1; i <= m; i++) {
            int sum = 0;
            for (int j = info[i][0]; j <= info[i][1]; j++) {
                sum += hamNum[j];
            }
            if (sum != info[i][2]) {
                is = false;
                break;
            }
        }
        return is;
    }
}

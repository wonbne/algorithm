import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        arr = new int[n][2];
        max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(max);
    }

    static void dfs(int idx) {
        if (idx == n) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i][0] <= 0) {
                    count++;
                }
            }
            max = Math.max(count, max);
            return;
        }

        if (arr[idx][0] <= 0) {
            dfs(idx + 1);
            return;
        }

        boolean is = false;

        for (int i = 0; i < n; i++) {
            if (idx == i) {
                continue;
            }
            if (arr[i][0] > 0) {
                is = true;
            }
        }

        if (is) {
            for (int i = 0; i < n; i++) {
                if (idx == i) {
                    continue;
                }
                if (arr[i][0] > 0) {
                    arr[i][0] -= arr[idx][1];
                    arr[idx][0] -= arr[i][1];
                    dfs(idx + 1);
                    arr[i][0] += arr[idx][1];
                    arr[idx][0] += arr[i][1];
                }
            }
        } else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i][0] <= 0) {
                    count++;
                }
            }
            max = Math.max(count, max);
            return;
        }

    }

}

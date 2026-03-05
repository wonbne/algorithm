import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static int d, w, k, total, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            total = 0;
            min = Integer.MAX_VALUE;
            arr = new int[d][w];
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            cal(0, 0);
            System.out.println("#" + tc + " " + min);
        }
    }

    static void cal(int start, int count) {

        if (count >= min)
            return;
        if (start == d) {
            if (check()) {
                min = Math.min(count, min);
            }
            return;

        }

        int tmp[] = arr[start].clone();

        change(start, 0);
        cal(start + 1, count + 1);
        arr[start] = tmp.clone();

        change(start, 1);
        cal(start + 1, count + 1);
        arr[start] = tmp.clone();

        cal(start + 1, count);
    }

    static boolean check() {

        for (int i = 0; i < w; i++) {
            int count = 1;
            int comp = arr[0][i];
            boolean pass = false;
            for (int j = 1; j < d; j++) {
                if (comp == arr[j][i]) {
                    count++;
                } else {
                    count = 1;
                    comp = arr[j][i];
                }
                if (count == k) {
                    pass = true;
                    break;
                }
            }
            if (!pass)
                return false;
        }
        return true;
    }

    static void change(int x, int a) {
        for (int i = 0; i < w; i++) {
            arr[x][i] = a;
        }
    }
}
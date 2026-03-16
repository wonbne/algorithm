import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n, total;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        arr = new int[n];
        total = 0;
        dfs(0);
        System.out.println(total);
    }

    static void dfs(int row) {
        if (row == n) {
            total++;
            return;
        }
        for (int c = 0; c < n; c++) {
            arr[row] = c;
            if (isOk(row)) {
                dfs(row + 1);
            }
        }
    }

    static boolean isOk(int row) {
        for (int i = 0; i < row; i++) {
            if (arr[i] == arr[row]) {
                return false;
            }
            if (Math.abs(arr[i] - arr[row]) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}

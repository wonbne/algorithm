import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Integer> queue = new ArrayDeque<>();
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] sum = new int[n + m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    sum[i + j]++;
                }
            }
            int max = 0;
            for (int i = 1; i <= n + m; i++) {
                max = Math.max(max, sum[i]);
            }
            for (int i = 1; i <= n + m; i++) {
                if (max == sum[i]) {
                    queue.add(i);
                }
            }
            System.out.print("#" + tc + " ");
            while (!queue.isEmpty()) {
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
        }
    }
}
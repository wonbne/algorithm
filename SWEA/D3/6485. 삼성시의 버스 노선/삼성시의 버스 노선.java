import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringBuilder sb = new StringBuilder();

            int[] arr = new int[5001];
            int n = Integer.parseInt(br.readLine());
            for (int q = 0; q < n; q++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                for (int k = a; k <= b; k++) {
                    arr[k]++;
                }
            }
            int p = Integer.parseInt(br.readLine());
            sb.append("#" + tc);
            for (int i = 0; i < p; i++) {
                int c = Integer.parseInt(br.readLine());
                sb.append(" " + arr[c]);
            }
            System.out.println(sb);
        }
    }
}
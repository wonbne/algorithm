import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] bit = new int[31];
            boolean is = true;
            int idx = 0;
            while (m > 0) {
                bit[idx] = m % 2;
                m /= 2;
                idx++;
            }
            for (int i = 0; i < n; i++) {
                if (bit[i] == 0) {
                    is = false;
                    break;
                }
            }

            System.out.println("#" + tc + " " + (is ? "ON" : "OFF"));

        }
    }
}
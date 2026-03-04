import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            long n = Long.parseLong(br.readLine().trim());
            long count = 0;

            while (n != 2) {
                long sqrt = (long) Math.sqrt(n);
                if (sqrt * sqrt == n) {
                    n = sqrt;
                    count++;
                } else {
                    long next = (sqrt + 1) * (sqrt + 1);
                    count += next - n;
                    n = next;
                }
            }
            System.out.println("#" + tc + " " + count);
        }

    }
}
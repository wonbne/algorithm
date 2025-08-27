
import java.io.*;

public class Main {
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        d[1] = 0;
        int ans = dp(n);
        bw.write(ans + "\n");
        bw.flush();
    }

    public static int dp(int n) {
        if (n == 1) return 0;
        if (d[n] > 0) return d[n];
        d[n] = dp(n-1) + 1;
        if(n % 2 == 0) {
            d[n] = Integer.min(d[n], dp(n/2) + 1);
        }
        if(n % 3 == 0) {
            d[n] = Integer.min(d[n], dp(n/3) + 1);
        }
        return d[n];
    }
}

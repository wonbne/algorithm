
import java.io.*;

public class Main {
    static int[] arr = new int[12];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for(int i = 0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(dp(n) + "\n");
        }
        bw.flush();
    }
    public static int dp(int n){
        if(n == 1 || n == 2 || n == 3) return arr[n];
        arr[n] = dp(n-1) + dp(n-2) + dp(n-3);
        return arr[n];
    }
}

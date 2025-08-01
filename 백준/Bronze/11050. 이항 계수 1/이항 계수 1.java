
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int ans = factorial(n) / (factorial(k)*factorial(n-k));
        bw.write(ans+"\n");
        bw.flush();
    }

    public static int factorial(int n){
        if(n<=1) return 1;
        return n*factorial(n-1);
    }
}

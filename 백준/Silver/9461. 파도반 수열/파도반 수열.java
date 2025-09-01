
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        for(int i=4; i<=100; i++){
            arr[i] = arr[i-2] + arr[i-3];
        }
        for(int i = 1; i<=t; i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(arr[n] + "\n");
        }
        bw.flush();
    }
}

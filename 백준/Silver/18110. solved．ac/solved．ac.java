import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            bw.write("0\n");
            bw.flush();
            return;
        }
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int k = (int)Math.round(n * 0.15);
        int low = k;
        int high = n - k - 1;

        long sum = 0;
        for(int i = low; i<=high; i++){
            sum += arr[i];
        }
        int asw = (int)Math.round((double)sum / (high - low + 1));
        bw.write(asw + "\n");
        bw.flush();
    }

}

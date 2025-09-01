
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }

        for(int t = 0; t<m; t++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st1.nextToken());
            int j = Integer.parseInt(st1.nextToken());
            long sum = (i == 1) ? arr[j - 1] : (arr[j - 1] - arr[i-2]);
            bw.write(sum+"\n");
        }
        bw.flush();
    }
}

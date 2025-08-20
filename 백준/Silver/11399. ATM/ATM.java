
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);
        int sum = 0;
        int cum = 0;
        for(int i = 0; i<n; i++){
            cum += time[i];
            sum += cum;
        }
        bw.write(sum + "\n");
        bw.flush();
    }
}

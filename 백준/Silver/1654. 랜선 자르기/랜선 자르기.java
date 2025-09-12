import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long left = 1;
        long right = arr[n-1];
        long answer = 0;
        while(left <= right){
            long mid = (left + right) / 2;
            long sum = 0;
            for(int i =0; i<n; i++){
                sum += arr[i] / mid;
            }
            if(sum >= k){
                left = mid + 1;
                answer = mid;
            }
            else{
                right = mid - 1;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}

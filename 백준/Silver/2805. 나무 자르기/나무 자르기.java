
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = arr[n-1];
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            long sum = 0;
            for(int i = 0; i<n; i++){
                if(arr[i] > mid) sum += arr[i] - mid;
            }

            if(sum >= m){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }
}

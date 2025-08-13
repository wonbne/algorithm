
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        bw.write((int)Math.round((double)sum/n) + "\n");

        bw.write(arr[n/2] + "\n");

        int countMax = 0;
        int mode = arr[0];
        boolean pickedSecond = false;

        for (int i = 0; i < n; ) {
            int j = i + 1;
            while (j < n && arr[j] == arr[i]) j++;
            int cnt = j - i;

            if (cnt > countMax) {
                countMax = cnt;
                mode = arr[i];
                pickedSecond = false;
            } else if (cnt == countMax && !pickedSecond) {
                mode = arr[i];
                pickedSecond = true;
            }
            i = j;
        }

        bw.write(mode + "\n");


        int min = arr[0];
        int max = arr[n-1];
        bw.write(max - min +"\n");
        bw.flush();
    }
}

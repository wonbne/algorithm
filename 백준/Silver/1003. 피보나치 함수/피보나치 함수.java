
import java.io.*;

public class Main {

    static int[] zero = new int[41];
    static int[] one = new int[41];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        zero[0] = 1;
        zero[1] = 0;
        one[0] = 0;
        one[1] = 1;

        for(int i =2; i<=40; i++){
            zero[i] = zero[i-1] + zero[i-2];
            one[i] = one[i-1] + one[i-2];
        }

        for(int i = 0; i<n; i++){
            int[] count = new int[2];
            int k = Integer.parseInt(br.readLine());
            fibonacci(k, count);
            bw.write(count[0] + " " + count[1] + "\n");
        }
        bw.flush();
    }

    public static void fibonacci(int n, int[] count){
        count[0] = zero[n];
        count[1] = one[n];
    }

}

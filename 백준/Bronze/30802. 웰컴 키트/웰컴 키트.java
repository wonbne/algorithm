import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<6; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int shirt = 0;
        for(int i = 0; i<6; i++){
            if(a[i] == 0) continue;
            if(a[i] % t == 0){
                shirt += a[i] / t;
            }
            else{
                shirt += a[i] / t + 1;
            }
        }
        bw.write(String.valueOf(shirt) + "\n");
        bw.write(n / p + " " + n % p);
        bw.flush();
    }
}

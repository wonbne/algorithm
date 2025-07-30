import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = n>m?n:m;
        int min = n<m?n:m;
        for(int i = min; i>=1; i--){
            if(n%i==0 && m%i==0){
                bw.write(i +"\n");
                break;
            }
        }
        int k = max;
        while(true){
            if(k%n == 0 && k%m==0){
                bw.write(k +"\n");
                break;
            }
            k++;
        }
        bw.flush();
    }
}


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 0; i<n; i++){
            int sum = i;
            int t = i;
            while(t>0){
                sum += t % 10;
                t /= 10;
            }
            if(sum == n){
                result = i;
                break;
            }
        }
        bw.write(result + "\n");
        bw.flush();
    }
}

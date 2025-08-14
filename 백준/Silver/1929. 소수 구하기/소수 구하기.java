
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        for(int i = m; i<=n; i++){
            if(i == 1){
                continue;
            }
            if(i == 2){
                bw.write(i + "\n");
            }
            else{
                if(find(i) == true){
                    bw.write(i + "\n");
                }
            }
        }
        bw.flush();
    }
    public static boolean find(int n){
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}





import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        for(int i = 0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int i = coin.length-1;
        while(true){
            if(k == 0) break;
            if(k >= coin[i]){
                k -= coin[i];
                count++;
            }
            else{
                i--;
            }
        }
        bw.write(count + "\n");
        bw.flush();
    }
}

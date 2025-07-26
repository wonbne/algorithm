import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        int result = -1;
        for(int i = k/5; i>=0; i--){
            int t = k - (5*i);
            if(t % 3 == 0){
                result = i + (t/3);
                break;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}

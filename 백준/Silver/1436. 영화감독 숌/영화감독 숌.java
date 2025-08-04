import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        int n = 666;
        int count = 1;
        while(true) {
            if (String.valueOf(n).contains("666")) {
                if (count == k) {
                    bw.write(n+"\n");
                    break;
                }
                count++;
            }
            n++;
        }
        bw.flush();
    }


}

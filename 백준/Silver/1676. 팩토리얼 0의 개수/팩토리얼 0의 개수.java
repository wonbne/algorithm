
import java.io.*;
import java.math.BigInteger;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());
        BigInteger t = BigInteger.ONE;
        for(int i = 1; i<=k; i++){
            t = t.multiply(BigInteger.valueOf(i));
        }
        String s = t.toString();
        char[] c = s.toCharArray();
        int tmp = 0;
        for(int i = c.length-1; i>=0; i--){
            if(c[i] == '0'){
                tmp += 1;
            }
            else {
                break;
            }
        }
        bw.write(String.valueOf(tmp));
        bw.flush();
    }
}

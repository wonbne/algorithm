
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String k = br.readLine();
            if(k.equals("0")) break;
            char[] arr = k.toCharArray();
            String s = "";
            for(int i = arr.length-1; i >= 0; i--){
                s += arr[i];
            }
            if(s.equals(k)){
                bw.write("yes\n");
            }
            else{
                bw.write("no\n");
            }
        }
        bw.flush();
    }
}

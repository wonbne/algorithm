
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = 0, b = 0, c = 0;
        while(true){
            String[] input = br.readLine().split(" ");
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            c = Integer.parseInt(input[2]);
            if(a == 0 && b == 0 && c == 0) break;
            if((a*a == (b*b + c*c)) || (b*b == (a*a + c*c)) || (c*c == (a*a + b*b))){
                bw.write("right\n");
            }
            else{
                bw.write("wrong\n");
            }
        }
        bw.flush();
    }

}

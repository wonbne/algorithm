
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();
        int count = 0;
        if(str1.matches("\\d+")) {
            count = Integer.parseInt(str1) + 3;
        }
        else if(str2.matches("\\d+")) {
            count = Integer.parseInt(str2) + 2;
        }
        else if(str3.matches("\\d+")){
            count = Integer.parseInt(str3) + 1;
        }

        if(count % 3 == 0 && count % 5 == 0){
            bw.write( "FizzBuzz\n");
        } else if (count % 3 == 0) {
            bw.write("Fizz\n");
        }
        else if (count % 5 == 0) {
            bw.write("Buzz\n");
        }
        else{
            bw.write(count + "\n");
        }
        bw.flush();

    }
}

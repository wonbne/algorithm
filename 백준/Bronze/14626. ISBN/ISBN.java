
import java.io.*;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String isbn = br.readLine();
        char[] ch = new char[isbn.length()];

        int starweight = 0;
        int count = 0;
        for(int i = 0; i < isbn.length(); i++) {
            ch[i] = isbn.charAt(i);
            int weight = i % 2 == 0 ? 1 : 3;
            if(ch[i] == '*'){
                starweight = weight;
                continue;
            }
            count += weight * (ch[i] - '0');
        }
        int answer = 0;
        for(int i = 0; i<=9; i++){
            if((count + starweight * i) % 10 == 0){
                answer = i;
                break;
            }
        }
        bw.write(answer + "\n");
        bw.flush();

    }
}

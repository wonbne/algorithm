
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] split = s.split("-");
        int result = 0;
        String[] fir = split[0].split("\\+");
        for(int i = 0; i<fir.length; i++) {
            result += Integer.parseInt(fir[i]);
        }

        for(int i = 1; i<split.length; i++) {
            String[] remain = split[i].split("\\+");
            int rem = 0;
            for(int j = 0; j<remain.length; j++) {
                rem += Integer.parseInt(remain[j]);
            }
            result -= rem;
        }

        bw.write(result + "\n");
        bw.flush();
    }
}

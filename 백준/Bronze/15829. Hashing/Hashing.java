
    import java.io.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            long L = Integer.parseInt(br.readLine());
            String s = br.readLine();
            long r = 1;
            long  m = 1234567891;
            long count = 0;
            for(int i = 0; i<L; i++){
                int v = s.charAt(i) - 'a' + 1;
                count = (count + (v * r) % m) % m;
                r = (r * 31) % m;
            }
            bw.write(count + "\n");
            bw.flush();
        }
    }

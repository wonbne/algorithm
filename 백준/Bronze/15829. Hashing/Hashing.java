
    import java.io.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int L = Integer.parseInt(br.readLine());
            String s = br.readLine();
            double count = 0;
            for(int i = 0; i<L; i++){
                count += (s.charAt(i) - 'a' + 1) * Math.pow(31, i);
            }
            bw.write((int)count + "\n");
            bw.flush();
        }
    }

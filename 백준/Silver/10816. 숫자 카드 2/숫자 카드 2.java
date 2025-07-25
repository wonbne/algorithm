
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            String s = st.nextToken();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int t = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < t; i++) {
            String s = st.nextToken();
            bw.write(map.getOrDefault(s, 0) + " ");
        }

        bw.flush();
    }
}

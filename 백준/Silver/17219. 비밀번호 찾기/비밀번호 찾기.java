
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[][] email = new String[n][2];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<2; j++){
                email[i][j] = st.nextToken();
            }
        }
        Arrays.sort(email, Comparator.comparing(a -> a[0]));
        for(int i = 0; i<m; i++){
            String find = br.readLine();
            int idx = Arrays.binarySearch(email, new String[]{find, ""}, Comparator.comparing(a -> a[0]));
            bw.write( email[idx][1] + "\n");

        }
        bw.flush();
    }
}

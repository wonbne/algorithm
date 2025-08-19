
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] listen = new String[n];
        for(int i = 0; i<n; i++){
            listen[i] = br.readLine();
        }

        Arrays.sort(listen);
        ArrayList<String> check = new ArrayList<>();
        for(int i = 0; i<m; i++){
            String see = br.readLine();
            if(Arrays.binarySearch(listen, see) >= 0){
                check.add(see);
            }
        }
        bw.write(check.size() + "\n");
        Collections.sort(check);
        for(int i = 0; i<check.size(); i++){
            bw.write(check.get(i) + "\n");
        }
        bw.flush();
    }
}

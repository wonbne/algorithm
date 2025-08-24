
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            Map<String, Integer> clothes = new HashMap<String, Integer>();
            for(int j = 0; j<k; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String type = st.nextToken();
                clothes.put(type, clothes.getOrDefault(type,0)+1);
            }
            int answer = 1;
            for(int count : clothes.values()){
                answer *= count + 1;
            }
            bw.write(answer - 1 + "\n");
        }
        bw.flush();
    }
}


import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] sorted = new int[n];
        int[] real = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            sorted[i] = Integer.parseInt(st.nextToken());
            real[i] = sorted[i];
        }
        Arrays.sort(sorted);
        int rank = 0;
        int former = sorted[0];
        Map<Integer, Integer> answer = new HashMap<>();
        for (int i = 0; i < n; i++){
            if(sorted[i] == former){
                answer.put(sorted[i], rank);
            }else{
                answer.put(sorted[i], ++rank);
                former = sorted[i];
            }
        }
        for (int i = 0; i < n; i++){
            bw.write(answer.get(real[i]) + " ");
        }
        bw.flush();
    }
}

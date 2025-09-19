
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> fruits = new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int maxLength = 0;
        for(int end = 0; end < n; end++) {
            if (fruits.containsKey(arr[end])) {
                fruits.put(arr[end], fruits.get(arr[end]) + 1);
            } else {
                fruits.put(arr[end], 1);
            }

            while (fruits.size() > 2) {
                fruits.put(arr[start], fruits.get(arr[start]) - 1);
                if (fruits.get(arr[start]) == 0) {
                    fruits.remove(arr[start]);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);

        }
        bw.write(maxLength + "");
        bw.flush();
    }

}

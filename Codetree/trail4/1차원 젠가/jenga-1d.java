import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int s1 = Integer.parseInt(st.nextToken());
        int e1 = Integer.parseInt(st.nextToken());
        for (int i = s1; i <= e1; i++) {
            arr[i] = 0;
        }
        int[] tmp = new int[n+1];
        int idx = 1;
        for(int i = 1; i<=n; i++){
            if(arr[i] != 0){
                tmp[idx++] = arr[i];
            }
        }

        st = new StringTokenizer(br.readLine().trim());
        int s2 = Integer.parseInt(st.nextToken());
        int e2 = Integer.parseInt(st.nextToken());
        for (int i = s2; i <= e2; i++) {
            tmp[i] = 0;
        }
        int count = 0;
        for(int i = 1; i<=n; i++){
            if(tmp[i] != 0){
                count++;
            }
        }
        System.out.println(count);
        for(int i = 1; i<=n; i++){
            if(tmp[i] != 0){
                System.out.println(tmp[i]);
            }
        }

    }


}
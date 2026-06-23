
import java.io.*;
import java.util.*;
public class Main {
    static int n,m,k;
    static int[] arr, com;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[k+1];
        st = new StringTokenizer(br.readLine());
        com = new int[n];
        for(int i = 0; i<n; i++){
            com[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= k; i++){
            arr[i] = 1;
        }
        max = 0;
        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int count){
        if(count == n){
            int c = 0;
            for(int i = 1; i<=k; i++){
                if(arr[i] >= m){
                    c++;
                }
            }
            max = Math.max(max, c);
            return;
        }

        for(int i = 1; i<=k; i++){

            arr[i] += com[count];
            dfs(count+1);
            arr[i] -= com[count];
        }
    }
}
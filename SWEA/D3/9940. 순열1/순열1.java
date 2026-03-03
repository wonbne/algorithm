import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for(int tc = 1; tc<=t; tc++){
            n = Integer.parseInt(br.readLine().trim());
            arr = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for(int i = 1; i<=n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            boolean is = true;
            for(int i = 1; i<=n; i++){
                if(arr[i] != i){
                    is = false;
                    break;
                }
            }
            System.out.println("#"+tc+" "+ (is?"Yes" : "No"));
        }
    }
}
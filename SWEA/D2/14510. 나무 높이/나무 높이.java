import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int max = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i]);
            }
            int odd = 0;
            int even = 0;
            for (int i = 0; i < n; i++) {
                int sub = max - arr[i];
                even += sub /2;
                odd += sub %2;
            }
            while(even - odd > 1){
                even--;
                odd+= 2;
            }

            int count = 0;
            if(odd>even){
                count = odd*2-1;
            } else if(even > odd){
                count = even *2;
            } else{
                count = odd + even;
            }

            System.out.println("#"+tc+" "+ count);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static boolean[] isBreak;
    static int[] arr;
    static int maxPoint;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=t; tc++) {
            n = Integer.parseInt(br.readLine());
            isBreak = new boolean[n];
            arr = new int[n];
            maxPoint = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0);
            System.out.println("#"+tc + " "+ maxPoint);
        }
    }
     
    public static void dfs(int point) {
        boolean done = true;
        for(int i = 0; i<n; i++) {
            if(!isBreak[i]) {
                done = false;
            }
        }
        if(done) {
            maxPoint = Math.max(maxPoint, point);
            return;
        }
         
        for(int i = 0; i<n; i++) {
            if(!isBreak[i]) {
                int left = i-1; 
                while(left>=0 && isBreak[left]) left--;
                 
                int right = i+1;
                while(right <n && isBreak[right]) right++;
                 
                int sum = 0;
                if(left>= 0 && right<n) {
                    sum += arr[left] * arr[right];
                } else if(left>=0) {
                    sum += arr[left];
                } else if(right <n) {
                    sum += arr[right];
                } else {
                    sum += arr[i];
                }
                isBreak[i] = true;
                dfs(point + sum);
                isBreak[i] = false;
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int n,m;
    static long answer;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for(int tc = 1; tc<=t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            time = new int[n];
            answer = Long.MAX_VALUE;
            for(int i = 0; i<n; i++){
                time[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(time);
            find(0, time[n-1] * (long)m);
            System.out.println("#"+tc+" "+answer);
        }
    }

    public static void find(long left, long right){
        long mid = (left +right)/2;
        long sum = 0;
        if(left > right){
            return;
        }
        for(int i = 0; i<time.length; i++){
            sum += mid/time[i];
        }
        if(sum < m){
            find(mid+1, right);
        }else{
            find(left, mid-1);
            answer = Math.min(answer, mid);
        }
    }
}
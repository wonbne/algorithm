import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;

        for(int tc = 1; tc<=t; tc++){
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[st.countTokens()];

            int idx = 0;
            int max = 0;
            int min = Integer.MAX_VALUE;
            int maxidx = 0;
            int minidx = 0;
            while(st.hasMoreTokens()){
                int now = Integer.parseInt(st.nextToken());
                if(max < now){
                    maxidx = idx;
                    max = now;
                }
                if(min > now){
                    minidx = idx;
                    min = now;
                }
                arr[idx++] = now;
            }

            while(n > 0){
                if(arr[maxidx] - arr[minidx] <= 1) break;

                arr[maxidx] -= 1;
                arr[minidx] += 1;

                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                for(int i = 0; i<arr.length; i++){
                    if(max < arr[i]){
                        max = arr[i];
                        maxidx = i;
                    }
                    if(min > arr[i]){
                        min = arr[i];
                        minidx = i;
                    }
                }
                n--;
            }
            System.out.println("#"+tc+" "+(arr[maxidx] - arr[minidx]));
        }


    }
}
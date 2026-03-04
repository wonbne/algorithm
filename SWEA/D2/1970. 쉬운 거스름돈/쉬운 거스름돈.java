import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for(int tc = 1; tc<=t; tc++){
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[8];
            while(n>=10){
                if(n>=50000){
                    n-=50000;
                    arr[0]++;
                } else if(n>=10000){
                    n-=10000;
                    arr[1]++;
                } else if(n>=5000){
                    n-=5000;
                    arr[2]++;
                } else if(n>=1000){
                    n-=1000;
                    arr[3]++;
                } else if(n>=500){
                    n-=500;
                    arr[4]++;
                } else if(n>=100){
                    n-=100;
                    arr[5]++;
                } else if(n>=50){
                    n-=50;
                    arr[6]++;
                } else if(n>=10){
                    n-=10;
                    arr[7]++;
                }
            }
            System.out.println("#"+tc);
            for(int a : arr){
                System.out.print(a+" ");
            }
            System.out.println();
        }   
    }
    
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=t; tc++){
            String s = br.readLine();
            int count = 0;
            int need = 0;
            for(int i = 1; i<=s.length(); i++){
                count += s.charAt(i-1) - '0';
                if(count<i){
                    need += i - count;
                    count = i;
                }
            }
            System.out.println("#"+tc +" " +need);
        }

    }
}
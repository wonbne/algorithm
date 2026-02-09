import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            ArrayList<String> arr1 = new ArrayList<>();
            ArrayList<String> arr2 = new ArrayList<>();
            if (n % 2 == 0) {
                for (int i = 0; i < n / 2; i++) {
                    arr1.add(st.nextToken());
                }
                for (int i = n / 2; i < n; i++) {
                    arr2.add(st.nextToken());
                }
            } else {
                for (int i = 0; i < n / 2 + 1; i++) {
                    arr1.add(st.nextToken());
                }
                for (int i = n / 2 + 1; i < n; i++) {
                    arr2.add(st.nextToken());
                }

            }
            sb.append("#" + tc + " ");

            for (int i = 0; i < arr1.size(); i++) {
                if(arr2.size()<=i){
                    sb.append(arr1.get(i));
                } else{
                    sb.append(arr1.get(i) + " ").append(arr2.get(i) + " ");
                }
            }
            System.out.println(sb);
        }
    }
}
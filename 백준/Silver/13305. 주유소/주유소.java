import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] price = new int[n];
        int[] km = new int[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i<n-1; i++){
            km[i] = Integer.parseInt(st.nextToken());

        }
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i<n; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }
        long total = 0;
        long minPrice = price[0];
        for(int i = 0; i<n-1; i++){
            if(price[i] < minPrice){
                minPrice = price[i];
            }
            total += minPrice * km[i];
        }
        System.out.println(total);
    }

}
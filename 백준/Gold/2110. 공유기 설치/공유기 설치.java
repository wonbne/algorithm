import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, c, max;
    static int[] home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        home = new int[n];
        max = 0;
        for (int i = 0; i < n; i++) {
            home[i] = Integer.parseInt(br.readLine().trim());
        }
        Arrays.sort(home);
        find(0, home[n-1]);
        System.out.println(max);
    }

    public static void find(int left, int right){
        int mid = (left + right) / 2;
        int count = 1;
        int last = 0;
        if(left > right){
            return;
        }
        for(int i = 1; i<n; i++){
            if(home[i] - home[last] >= mid){
                last = i;
                count++;
            }
        }

        if(count <c){
            find(left, mid-1);
        }else{
            find(mid+1, right);
            max = Math.max(max, mid);
        }


    }
}
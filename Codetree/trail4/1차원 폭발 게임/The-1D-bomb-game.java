import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int n, m, count;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        count = n;
        while(true){
            bomb();
            move();
            int c = 0;
            for(int i = 0; i<n; i++){
                if(arr[i] != 0){
                    c++;
                }
            }

            if(c == count){
                break;
            } else{
                count = c;
            }
        }
        System.out.println(count);
        for(int i = 0; i<count; i++){
            System.out.println(arr[i]);
        }

    }

    public static void bomb(){
        int c = 1;
        int start = 0;
        int now = arr[0];
        for(int i = 1; i<n; i++){
            if(arr[i] == now){
                c++;
            }else{
                if(c >= m){
                    for(int j = start; j<start+c; j++){
                        arr[j] = 0;
                    }
                }
                start = i;
                c = 1;
                now = arr[i];
            }
        }
        if(c >= m){
            for(int j = start; j<start+c; j++){
                arr[j] = 0;
            }
        }
    }

    public static void move(){
        int idx = 0;
        for(int i = 0; i<n; i++){
            if(arr[i] != 0){
                arr[idx] = arr[i];
                idx++;
            }
        }
        for(int i = idx; i<n; i++){
            arr[i] = 0;
        }
    }


}
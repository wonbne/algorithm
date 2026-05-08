import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int[][] arr;
    static int n,m,k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean is = false;

        exit :
        for(int i = 1; i<=n; i++){
            for(int j = k; j<k+m; j++){
                if(arr[i][j] == 1){
                    is = true;
                    for(int q = k; q<k+m; q++){
                        arr[i-1][q] = 1;
                    }
                    break exit;
                }
            }
        }

        if(!is){
            for(int i = k; i<k+m; i++){
                arr[n][i] = 1;
            }
        }



        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
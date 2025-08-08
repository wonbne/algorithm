
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[][] arr = new int[15][15];
        for(int i = 1; i<=14; i++){
            arr[0][i] = i;
        }
        for(int i = 1; i<=14; i++){
            arr[i][1] = 1;
            for(int j = 1; j<=14; j++){
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }
        for(int i = 0;i<t;i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            bw.write(arr[k][n] + "\n");
        }
        bw.flush();
    }
}

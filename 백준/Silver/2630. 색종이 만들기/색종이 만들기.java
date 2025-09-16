
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0,0,n);
        bw.write(white+"\n");
        bw.write(blue+"\n");
        bw.flush();
    }

    static void solve(int x, int y, int n){
        int fir = arr[x][y];
        boolean check = true;

        for(int i = x; i<x+n; i++){
            for(int j = y; j<y+n; j++){
                if(arr[i][j] != fir){
                    check = false;
                    break;
                }
            }
        }

        if(check){
            if(fir == 0){
                white++;
            }else{
                blue++;
            }
            return;
        }
        int half = n/2;
        solve(x, y, half);
        solve(x, y+half, half);
        solve(x+half, y, half);
        solve(x+half, y+half, half);
    }
}

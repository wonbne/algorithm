
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int b;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }
        int answerTime = Integer.MAX_VALUE;
        int answerH = -1;
        for(int h = min; h <= max; h++) {
            int time = 0;
            int block = b;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(arr[i][j] < h) {
                        time += h-arr[i][j];
                        block -= h-arr[i][j];
                    }else if (arr[i][j]>h) {
                        time += (arr[i][j]-h) * 2;
                        block += arr[i][j]-h;
                    }
                }
            }
            if(block >= 0){
                if(time <= answerTime){
                    answerTime = time;
                    answerH = h;
                }

            }
        }
        bw.write(answerTime + " " + answerH);
        bw.flush();
    }
}

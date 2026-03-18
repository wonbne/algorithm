import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dpMax = new int[n][3];
        int[][] dpMin = new int[n][3];

        for (int i = 0; i < 3; i++) {
            dpMax[0][i] = arr[0][i];
            dpMin[0][i] = arr[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int tmpMax = 0;
                int tmpMin = Integer.MAX_VALUE;
                for (int k = j-1; k <= j+1; k++) {
                    if (k < 0 || k >= 3)
                        continue;
                    tmpMax = Math.max(dpMax[i-1][k],tmpMax);
                    tmpMin = Math.min(dpMin[i-1][k],tmpMin);
                }
                dpMax[i][j] = tmpMax + arr[i][j];
                dpMin[i][j] = tmpMin + arr[i][j];
            }
        }

        int max = 0; 
        int min = Integer.MAX_VALUE;

        for(int i = 0; i<3; i++){
            max = Math.max(max, dpMax[n-1][i]);
            min = Math.min(min, dpMin[n-1][i]);
        }
        System.out.println(max + " " + min);
    }
}

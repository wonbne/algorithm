import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        int[] dpMax = new int[3];
        int[] dpMin = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < 3; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            dpMax[i] = tmp;
            dpMin[i] = tmp;
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int cpyMax0 = dpMax[0], cpyMax1 = dpMax[1], cpyMax2 = dpMax[2];
            int cpyMin0 = dpMin[0], cpyMin1 = dpMin[1], cpyMin2 = dpMin[2];

            dpMax[0] = Math.max(cpyMax0, cpyMax1) + a;
            dpMax[1] = Math.max(Math.max(cpyMax0, cpyMax1), cpyMax2) + b;
            dpMax[2] = Math.max(cpyMax1, cpyMax2) + c;

            dpMin[0] = Math.min(cpyMin0, cpyMin1) + a;
            dpMin[1] = Math.min(Math.min(cpyMin0, cpyMin1), cpyMin2) + b;
            dpMin[2] = Math.min(cpyMin1, cpyMin2) + c;
        }

        int max = Math.max(Math.max(dpMax[0], dpMax[1]), dpMax[2]);
        int min = Math.min(Math.min(dpMin[0], dpMin[1]), dpMin[2]);
        System.out.println(max + " " + min);

    }
}

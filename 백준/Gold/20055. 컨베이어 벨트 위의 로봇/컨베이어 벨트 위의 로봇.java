import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] belt;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        belt = new int[2 * n + 1];
        robot = new boolean[2 * n + 1];
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 1; i <= 2 * n; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        int step = 1; //단계
        while (true) {
            int temp = belt[2*n];
            for(int i = 2*n; i>=2; i--){
                belt[i] = belt[i-1];
            }
            belt[1] = temp;

            for(int i = n; i>=2; i--) {
                robot[i] = robot[i-1];
            }
            robot[1] = false;

            robot[n] = false; // 내리기

            for(int i = n-1; i>=1; i--){
                if(robot[i] && !robot[i+1] && belt[i+1]>0){
                    robot[i+1] = true;
                    robot[i] = false;
                    belt[i+1]--;
                    if(belt[i+1] == 0) count++;
                }
            }

            robot[n] = false; // 내리기

            if(belt[1] > 0){
                belt[1]--;
                robot[1] = true;
                if(belt[1] == 0) count++;
            }



            if(count >= k) break;
            step++;

        }

        System.out.println(step);

    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static int[][] arr;
    static int n;
    static int m;
    static int c;
    static int totalMax;
    static int max1;
    static int max2;
    static int[] honeyBox1;
    static int[] honeyBox2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            totalMax = 0;
            max1 = 0;
            max2 = 0;
            honeyBox1 = new int[m];
            honeyBox2 = new int[m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n - m; j++) {
                    int idx = 0;
                    for (int q = j; q < j + m; q++) {
                        honeyBox1[idx++] = arr[i][q];
                        if (q == j + m - 1) {
                            max1 = 0;
                            cal(0, 0, 1, 0);
                            max2 = 0;
                            makeHoneyBox2(i, q);
                            totalMax = Math.max(totalMax, max1 + max2);

                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + totalMax);

        }

    }

    public static void makeHoneyBox2(int x, int y) {

        if (y + m < n) {
            for (int j = y + 1; j <= n - m; j++) {
                int idx = 0;

                for (int q = j; q < j + m; q++) {
                    honeyBox2[idx++] = arr[x][q];
                }
                cal(0, 0, 2, 0);
            }
        }

        for (int i = x + 1; i < n; i++) {
            for (int j = 0; j <= n - m; j++) {
                int idx = 0;
                for (int q = j; q < j + m; q++) {
                    honeyBox2[idx++] = arr[i][q];
                }
                cal(0, 0, 2, 0);

            }
        }
    }

    public static void cal(int start, int sum, int state, int sumSquare) {
        if (state == 1) {
            if (sum > c) {
                return;
            }
            if (start == m) {
                max1 = Math.max(max1, sumSquare);
                return;
            }
            int val = honeyBox1[start];
            cal(start + 1, sum + honeyBox1[start], state, sumSquare + val * val);
            cal(start + 1, sum, state, sumSquare);
        } else {
            if (sum > c) {
                return;
            }
            if (start == m) {

                max2 = Math.max(max2, sumSquare);
                return;
            }
            int val = honeyBox2[start];
            cal(start + 1, sum + honeyBox2[start], state, sumSquare + val * val);
            cal(start + 1, sum, state, sumSquare);
        }
    }

}
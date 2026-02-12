import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int c = 1; c <= T; c++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[m];
            int max = 0;

            for (int i = 0; i < n; i++) {
                arr1[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                arr2[i] = sc.nextInt();
            }

            int sum = 0;
            if (n > m) {
                for (int i = 0; i <= n - m; i++) {
                    sum = 0;
                    for (int j = 0; j < m; j++) {
                        sum += arr1[i + j] * arr2[j];
                    }
                    max = Math.max(sum, max);

                }
            } else {
                for (int i = 0; i <= m - n; i++) {
                    sum = 0;
                    for (int j = 0; j < n; j++) {
                        sum += arr1[j] * arr2[i + j];
                    }
                    max = Math.max(sum, max);

                }
            }
            System.out.println("#" + c + " " + max);

        }
    }
}
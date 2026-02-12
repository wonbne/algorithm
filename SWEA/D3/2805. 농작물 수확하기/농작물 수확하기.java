import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int c = 1; c <= tc; c++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int sum = 0;
            int mid = n / 2;
            int left = mid;
            int right = mid;
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.charAt(j) - '0';
                }
            }
            for (int i = 0; i < mid; i++) {
                for (int j = left; j <= right; j++) {
                    sum += arr[i][j];

                }
                left--;
                right++;
            }

            for (int i = mid; i < n; i++) {
                for (int j = left; j <= right; j++) {
                    sum += arr[i][j];

                }
                left++;
                right--;
            }
            System.out.println("#" + c + " " + sum);
        }
    }
}
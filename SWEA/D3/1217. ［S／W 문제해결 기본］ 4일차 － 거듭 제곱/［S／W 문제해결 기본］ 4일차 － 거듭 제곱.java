import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int t = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println("#" + tc + " " + pow(n, m));
        }
    }

    static int pow(int n, int m) {
        if (m == 0)
            return 1;
        if (m % 2 == 0) {
            return pow(n, m/2) * pow(n, m/2);
        } else {
            return pow(n, m / 2) * pow(n, m / 2) * n;
        }
    }
}
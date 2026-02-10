import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];

            // 배열 입력
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int maxCount = 0;
            // 하나씩 찾아본다
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int cal = 0;
                    int count = 0;
                    int left = 0;
                    int right = 0;
                    for (int size = 1; size <= n + 1; size++) {
                        count = 0;
                        left = 0;
                        right = 0;
                        for (int k = i - size + 1; k <= i; k++) {
                            for (int q = j - left; q <= j + right; q++) {
                                if (q >= 0 && q < n && k >= 0 && k < n && arr[k][q] == 1) {
                                    count++;
                                }
                            }
                            if (k < i) {
                                left++;
                                right++;
                            }
                        }
                        left--;
                        right--;
                        for (int k = i + 1; k <= i + size - 1; k++) {
                            for (int q = j -left; q <= j + right; q++) {
                                if (q >= 0 && q < n && k < n && k >= 0 && arr[k][q] == 1) {
                                    count++;
                                }
                            }
                            left--;
                            right--;
                        }
                        cal = (count * m) - (size * size + (size - 1) * (size - 1));
                        if (cal >= 0) {
                            maxCount = Math.max(maxCount, count);
                        }
                    }
                }
            }
            sb.append("#" + tc + " " + maxCount);
            System.out.println(sb);
        }
    }
}
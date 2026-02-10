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
            char[][] arr = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }

            int min = Integer.MAX_VALUE;
            int count = 0;
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    count = 0;
                    for (int r = 0; r <= i; r++) {
                        for (int c = 0; c < m; c++) {
                            if (arr[r][c] != 'W') {
                                count++;
                            }
                        }
                    }

                    for (int r = i + 1; r <= j; r++) {
                        for (int c = 0; c < m; c++) {
                            if (arr[r][c] != 'B') {
                                count++;
                            }
                        }

                    }
                    for (int r = j + 1; r < n; r++) {
                        for (int c = 0; c < m; c++) {
                            if (arr[r][c] != 'R') {
                                count++;
                            }
                        }
                    }
                    min = Math.min(min, count);

                }

            }

            sb.append("#" + tc + " " + min);
            System.out.println(sb);
        }

    }
}
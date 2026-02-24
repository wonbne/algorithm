import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static int n;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { -1, 0, 1, 0 };
    // 좌 : 0 상 : 1 우 : 2 하 : 3
    static int[][] block = { {}, { 1, 3, 0, 2 }, { 3, 2, 0, 1 }, { 2, 0, 3, 1 }, { 2, 3, 1, 0 }, { 2, 3, 0, 1 } };
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine().trim());
            arr = new int[n][n];
            max = 0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 0) {
                        pinball(i, j, 0);
                        pinball(i, j, 1);
                        pinball(i, j, 2);
                        pinball(i, j, 3);
                    }
                }
            }
            System.out.println("#" + tc + " " + max);
        }
    }

    public static void pinball(int startX, int startY, int startDir) {
        int cx = startX;
        int cy = startY;
        int cDir = startDir;
        int sum = 0;
        while (true) {
            int nx = dx[cDir] + cx;
            int ny = dy[cDir] + cy;

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                switch (cDir) {
                    case 0:
                        sum += 1;
                        cDir = 2;
                        cx = nx;
                        cy = ny;
                        break;
                    case 1:
                        sum += 1;
                        cDir = 3;
                        cx = nx;
                        cy = ny;
                        break;
                    case 2:
                        sum += 1;
                        cDir = 0;
                        cx = nx;
                        cy = ny;
                        break;
                    case 3:
                        sum += 1;
                        cDir = 1;
                        cx = nx;
                        cy = ny;
                        break;
                }
                continue;
            }

            if ((nx == startX && ny == startY) || arr[nx][ny] == -1) {
                max = Math.max(sum, max);
                break;
            }

            if (arr[nx][ny] >= 1 && arr[nx][ny] <= 5) {
                cDir = block[arr[nx][ny]][cDir];
                sum += 1;
                cx = nx;
                cy = ny;
            } else if (arr[nx][ny] >= 6 && arr[nx][ny] <= 10) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (arr[i][j] == arr[nx][ny]) {
                            if (i == nx && j == ny) {
                                continue;
                            } else {
                                cx = i;
                                cy = j;
                                i = n-1;
                                break;
                            }
                        }
                    }
                }
            } else if(arr[nx][ny]== 0){
                cx = nx;
                cy = ny;
            }
        }

    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= t; tc++) {
			int k = Integer.parseInt(br.readLine().trim());

			int[][] arr = new int[4][8];
			int[][] check = new int[4][2];

			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < 8; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken().trim());
				}
			}

			for (int i = 0; i < 4; i++) {
				check[i][0] = 6;
				check[i][1] = 2;
			}

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                int left = num - 1;
                int right = num - 1;

                // 왼쪽 전파: left 범위만 계산
                while (left - 1 >= 0) {
                    if (arr[left - 1][check[left - 1][1]] != arr[left][check[left][0]]) {
                        left--;
                    } else {
                        break;
                    }
                }

                // 오른쪽 전파: right 범위만 계산
                while (right + 1 < 4) {
                    if (arr[right + 1][check[right + 1][0]] != arr[right][check[right][1]]) {
                        right++;
                    } else {
                        break;
                    }
                }

                // 현재 톱니바퀴 회전
                check[num-1][0] = ((check[num-1][0] - dir) + 8) % 8;
                check[num-1][1] = ((check[num-1][1] - dir) + 8) % 8;

                // 왼쪽 톱니바퀴들 회전
                int leftDir = dir;
                for (int l = num - 2; l >= left; l--) {
                    leftDir = -leftDir;
                    check[l][0] = ((check[l][0] - leftDir) + 8) % 8;
                    check[l][1] = ((check[l][1] - leftDir) + 8) % 8;
                }

                // 오른쪽 톱니바퀴들 회전
                int rightDir = dir;
                for (int r = num; r <= right; r++) {
                    rightDir = -rightDir;
                    check[r][0] = ((check[r][0] - rightDir) + 8) % 8;
                    check[r][1] = ((check[r][1] - rightDir) + 8) % 8;
                }
            }

            int sum = 0;
            for (int i = 0; i < 4; i++) {
                if (arr[i][(check[i][0] + 2) % 8] == 1) {
                    sum += (int) Math.pow(2, i);
                }
            }

            System.out.println("#" + tc + " " + sum);
        }
	}
}
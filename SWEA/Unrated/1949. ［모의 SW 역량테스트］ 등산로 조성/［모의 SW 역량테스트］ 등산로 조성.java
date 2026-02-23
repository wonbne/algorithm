import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int[][] arr;
	public static int k;
	public static int n;
	public static boolean[][] visited;
	public static int max;
	public static int[] dx = { 0, -1, 0, 1 };
	public static int[] dy = { -1, 0, 1, 0 };
	public static int highest;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			visited = new boolean[n][n];
			max = 0;
			highest = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					arr[i][j] = tmp;
					highest = Math.max(highest, tmp);
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == highest) {
						visited[i][j] = true;
						dfs(i, j, 1, false);
						visited[i][j] = false;
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}

	public static void dfs(int x, int y, int length, boolean is) {
		max = Math.max(length, max);

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (!visited[nx][ny] && arr[x][y] > arr[nx][ny]) {
					visited[nx][ny] = true;
					dfs(nx, ny, length + 1, is);
					visited[nx][ny] = false;
				} else if (!visited[nx][ny] && arr[x][y] <= arr[nx][ny]) {
					if (is) {
						continue;
					} else {
						for (int i = 1; i <= k; i++) {
							if (arr[nx][ny] - i < arr[x][y]) {
								visited[nx][ny] = true;
								arr[nx][ny] -= i;
								dfs(nx, ny, length + 1, true);
								arr[nx][ny] += i;
								visited[nx][ny] = false;
							}
						}

					}
				}
			}

		}

	}
}
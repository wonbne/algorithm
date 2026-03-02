import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
	static int n;
	static int startX;
	static int startY;
	static int endX;
	static int endY;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine().trim());
			arr = new int[n][n];
			visited = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited[i][j] = Integer.MAX_VALUE;
				}
			}
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine().trim());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());

			System.out.println("#" + tc + " " + bfs());
		}
	}

	static int bfs() {
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		queue.offer(new int[] { startX, startY, 0 });
		visited[startX][startY] = 0;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			int t = cur[2];

			if (visited[x][y] < t)
				continue;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				int nt = t + 1;

				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				if (arr[nx][ny] == 1)
					continue;

				if (arr[nx][ny] == 2) {
					if (nt % 3 != 0) {
						nt = (nt / 3 + 1) * 3;
					}
				}

				if (visited[nx][ny] > nt) {
					visited[nx][ny] = nt;
					queue.offer(new int[] { nx, ny, nt });
				}
			}
		}

		return visited[endX][endY] == Integer.MAX_VALUE ? -1 : visited[endX][endY];
	}
}
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
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int count = 0;
			boolean[][] road = new boolean[n][n];
			// 행 확인
			for (int i = 0; i < n; i++) {
				boolean check = true;
				for (int j = 0; j < n - 1; j++) {
					if (Math.abs(arr[i][j] - arr[i][j + 1]) == 1) {
						if (arr[i][j] - arr[i][j + 1] > 0) { // 내리막
							for (int q = 1; q <= x; q++) {
								if (j + q < n && arr[i][j + q] == arr[i][j] - 1) {
									continue;
								} else
									check = false;
							}
							if (check) {
								for (int q = 1; q <= x; q++) {
									if (road[i][j + q] != true) {
										road[i][j + q] = true;
									} else {
										check = false;
										break;
									}
								}

							}
						} else { // 오르막
							for (int q = 1; q <= x; q++) {
								if (j + 1 - q >= 0 && arr[i][j + 1 - q] == arr[i][j + 1] - 1) {
									continue;
								} else
									check = false;
							}
							if (check) {
								for (int q = 1; q <= x; q++) {
									if (road[i][j + 1 - q] != true) {
										road[i][j + 1 - q] = true;
									} else {
										check = false;
										break;
									}
								}

							}
						}
					} else if(Math.abs(arr[i][j] - arr[i][j + 1]) > 1) {
						check = false;
					}
				}
				if (check)
					count++;
			}
			road = new boolean[n][n];

			// 열 탐색
			for (int j = 0; j < n; j++) {
				boolean check = true;
				for (int i = 0; i < n - 1; i++) {
					if (Math.abs(arr[i][j] - arr[i + 1][j]) == 1) {
						if (arr[i][j] - arr[i + 1][j] > 0) { // 내리막
							for (int q = 1; q <= x; q++) {
								if (i + q < n && arr[i + q][j] == arr[i][j] - 1) {
									continue;
								} else
									check = false;
							}
							if (check) {
								for (int q = 1; q <= x; q++) {
									if (road[i + q][j] != true) {
										road[i + q][j] = true;
									} else {
										check = false;
										break;
									}
								}

							}
						} else { // 오르막
							for (int q = 1; q <= x; q++) {
								if (i + 1 - q >= 0 && arr[i + 1 - q][j] == arr[i + 1][j] - 1) {
									continue;
								} else
									check = false;
							}
							if (check) {
								for (int q = 1; q <= x; q++) {
									if (road[i + 1 - q][j] != true) {
										road[i + 1 - q][j] = true;
									} else {
										check = false;
										break;
									}
								}

							}
						}
					} else if(Math.abs(arr[i][j] - arr[i+1][j]) > 1) {
						check = false;
					}
				}
				if (check)
					count++;
			}

			System.out.println("#" + tc + " " + count);
		}
	}
}
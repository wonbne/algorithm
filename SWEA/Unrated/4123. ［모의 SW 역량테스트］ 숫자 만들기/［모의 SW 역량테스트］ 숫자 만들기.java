import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] op;
	static int n;
	static int[] arr;
	static int max;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine().trim());
			op = new int[4];
			arr = new int[n];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < 4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, arr[0]);
			System.out.println("#" + tc + " " + (max - min));
		}
	}

	public static void dfs(int count, int checkSum) {
		if (count == n - 1) {
			max = Math.max(max, checkSum);
			min = Math.min(min, checkSum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (op[i] > 0) {
				op[i]--;
				dfs(count + 1, cal(i, checkSum, arr[count + 1]));
				op[i]++;
			}
		}
	}

	public static int cal(int op, int a, int b) {
		switch (op) {
		case 0:
			return a + b;
		case 1:
			return a - b;
		case 2:
			return a * b;
		case 3:
			if (a < 0) {
				return -(Math.abs(a) / b);
			} else {
				return a / b;
			}
		default:
			return 0;
		}

	}
}
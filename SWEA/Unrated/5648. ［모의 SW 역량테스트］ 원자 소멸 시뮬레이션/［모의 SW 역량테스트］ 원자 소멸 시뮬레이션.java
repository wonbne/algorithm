
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int n, sum;
	static int[][] arr;
	static List<float[]> crash;
	static boolean[] visited;
	static boolean[] extinction;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine().trim());
			arr = new int[n][4];
			visited = new boolean[n];
			crash = new ArrayList<>();
			extinction = new boolean[n];
			sum = 0;
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				arr[i][2] = Integer.parseInt(st.nextToken());
				arr[i][3] = Integer.parseInt(st.nextToken());
			}
			select(0, 0);

			crash.sort((x, y) -> Float.compare(x[2], y[2]));

			int i = 0;
			while (i < crash.size()) {
				int j = i;
				while (j < crash.size() && crash.get(j)[2] == crash.get(i)[2]) {
					j++;
				}

				Set<Integer> toExtinct = new HashSet<>();
				for (int k = i; k < j; k++) {
					float[] tmp = crash.get(k);
					int atomA = (int) tmp[0];
					int atomB = (int) tmp[1];
					if (!extinction[atomA] && !extinction[atomB]) {
						toExtinct.add(atomA);
						toExtinct.add(atomB);
					}
				}

				for (int atom : toExtinct) {
					sum += arr[atom][3];
					extinction[atom] = true;
				}

				i = j;
			}
			System.out.println("#" + tc + " " + sum);
		}

	}

	public static void check(int a, int b) {
		if (arr[a][2] == 0) { // 상
			if (arr[a][1] < arr[b][1]
					&& ((arr[a][0] > arr[b][0] && arr[b][2] == 3) || (arr[a][0] < arr[b][0] && arr[b][2] == 2))) {
				if (Math.abs(arr[a][0] - arr[b][0]) == Math.abs(arr[a][1] - arr[b][1])) {
					float t = Math.abs(arr[a][0] - arr[b][0]);
					crash.add(new float[] { a, b, t });
				}
			} else if (arr[a][1] < arr[b][1] && arr[a][0] == arr[b][0] && arr[b][2] == 1) {
				float t = (arr[b][1] - arr[a][1]) / 2.0f;
				crash.add(new float[] { a, b, t });
			}
		} else if (arr[a][2] == 1) { // 하
			if (arr[a][1] > arr[b][1]
					&& ((arr[a][0] > arr[b][0] && arr[b][2] == 3) || (arr[a][0] < arr[b][0] && arr[b][2] == 2))) {
				if (Math.abs(arr[a][0] - arr[b][0]) == Math.abs(arr[a][1] - arr[b][1])) {
					float t = Math.abs(arr[a][0] - arr[b][0]);
					crash.add(new float[] { a, b, t });
				}
			} else if (arr[a][1] > arr[b][1] && arr[a][0] == arr[b][0] && arr[b][2] == 0) {
				float t = (arr[a][1] - arr[b][1]) / 2.0f;
				crash.add(new float[] { a, b, t });
			}
		} else if (arr[a][2] == 2) { // 좌
			if (arr[a][0] > arr[b][0]
					&& ((arr[a][1] > arr[b][1] && arr[b][2] == 0) || (arr[a][1] < arr[b][1] && arr[b][2] == 1))) {
				if (Math.abs(arr[a][0] - arr[b][0]) == Math.abs(arr[a][1] - arr[b][1])) {
					float t = Math.abs(arr[a][0] - arr[b][0]);
					crash.add(new float[] { a, b, t });
				}
			} else if (arr[a][0] > arr[b][0] && arr[a][1] == arr[b][1] && arr[b][2] == 3) {
				float t = (arr[a][0] - arr[b][0]) / 2.0f;
				crash.add(new float[] { a, b, t });
			}
		} else if (arr[a][2] == 3) { // 우
			if (arr[a][0] < arr[b][0]
					&& ((arr[a][1] > arr[b][1] && arr[b][2] == 0) || (arr[a][1] < arr[b][1] && arr[b][2] == 1))) {
				if (Math.abs(arr[a][0] - arr[b][0]) == Math.abs(arr[a][1] - arr[b][1])) {
					float t = Math.abs(arr[a][0] - arr[b][0]);
					crash.add(new float[] { a, b, t });
				}
			} else if (arr[a][0] < arr[b][0] && arr[a][1] == arr[b][1] && arr[b][2] == 2) {
				float t = (arr[b][0] - arr[a][0]) / 2.0f;
				crash.add(new float[] { a, b, t });
			}
		}
	}

	public static void select(int start, int count) {
		if (count == 2) {
			int a = -1;
			int b = -1;
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					if (a == -1)
						a = i;
					else
						b = i;
				}
			}
			check(a, b);
			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true;
			select(i+1, count + 1);
			visited[i] = false;
		}
	}
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, k, win;
	static int[] time, indegree,dp;
	static List<Integer>[] list;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			time = new int[n + 1];
			indegree = new int[n + 1];
			dp = new int[n+1];
			list = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++) {
				list[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 1; i <= n; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				indegree[b]++;
			}
			win = Integer.parseInt(br.readLine().trim());
			sort();
			System.out.println(dp[win]);
		}
	}
	
	public static void sort() {
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i<=n; i++) {
			if(indegree[i] == 0) {
				queue.add(i);
				dp[i] = time[i];
			}
		}
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int i : list[now]) {
				dp[i] = Math.max(dp[i], dp[now] + time[i]);
				indegree[i]--;
				if(indegree[i] == 0) {
					queue.add(i);
				}
			}

		}
	}
}

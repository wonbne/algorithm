import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] cost = new int[4];
	static int[] month = new int[12];
	static int min;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			min = cost[3];
			dfs(0,0);
			System.out.println("#"+tc+" "+min);
			
		}
		
		
	}
	
	public static void dfs(int monthCount, int sum) {
		if(monthCount >= 12) {
			min = Math.min(sum, min);
			return;
		}
		
		dfs(monthCount+1, sum+(month[monthCount]*cost[0]));
		dfs(monthCount+1, sum+cost[1]);
		dfs(monthCount+3, sum+cost[2]);
	}
}
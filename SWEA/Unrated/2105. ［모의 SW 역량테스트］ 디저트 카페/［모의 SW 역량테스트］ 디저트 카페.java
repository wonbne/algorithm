import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[][] arr;
	static int[] dx = { 1, -1, -1, 1 };
	static int[] dy = { 1, 1, -1, -1 };
	static boolean[] check;
	static int max ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			check = new boolean[101];
			max = -1;
			for(int i = 0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i= 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					check[arr[i][j]] = true;
					dfs(i, j, i, j, 0, 1);
					check[arr[i][j]] = false;
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}

	public static void dfs(int x, int y, int startX, int startY, int dir, int count) {
		
		for(int d = dir; d<=dir+1 && d < 4; d++) {
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx == startX && ny == startY && d == 3 && count >= 4) {
				max = Math.max(max, count);
				continue;
			}
			
			if(nx<0 || ny <0 || nx >=n || ny >= n ) {
				continue;
			}
			int checkDesert = arr[nx][ny];
			
			if(check[checkDesert] == false) {
				check[checkDesert] = true;
				dfs(nx,ny,startX,startY, d, count+1);
				check[checkDesert] = false;
			}
			
		}
		
	}

}
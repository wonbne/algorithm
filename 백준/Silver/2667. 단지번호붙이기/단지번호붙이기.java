
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[][] visited;
	static int[][] arr;
	static int n;
	static ArrayList ans = new ArrayList<>();
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		visited = new boolean[n][n];
		for(int i = 0; i<n; i++) {
			String s = sc.next();
			for(int j = 0; j<n; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(arr[i][j] == 1 && !visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		System.out.println(ans.size());
		Collections.sort(ans);
		for(int i = 0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		visited[x][y] = true;
		queue.add(new int[] {x,y});
		int count = 1;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for(int i = 0; i<4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny] && arr[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny});
					count++;
				}
			}
			
		}
		ans.add(count);
	}

}

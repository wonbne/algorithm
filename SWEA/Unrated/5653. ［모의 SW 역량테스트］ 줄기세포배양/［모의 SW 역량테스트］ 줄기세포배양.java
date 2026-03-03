import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			Cell[][] map = new Cell[N + (K * 2)][M + (K * 2)];
			List<int[]> livingCells = new ArrayList<>();	// 살아있는 세포의 위치정보를 저장할 리스트
			
			for (int i = K; i < K + N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = K; j < K + M; j++) {
					int hp = Integer.parseInt(st.nextToken());
					
					if (hp > 0) {
						map[i][j] = new Cell(0, hp, hp);
						livingCells.add(new int[] {i, j});
					}
				}
			}
			
			int time = 0;
			while(time <= K) {
				for (int i = livingCells.size() - 1; i >= 0; i--) {
					int y = livingCells.get(i)[0];
					int x = livingCells.get(i)[1];
					Cell cell = map[y][x];
					
					// 활성화 후 한 시간 지난 세포 처리
					if (cell.activeAt + 1 == time) {
						
						// 상하좌우 방면으로 번식
						for (int j = 0; j < 4; j++) {
							Cell newCell = map[y + dy[j]][x + dx[j]];
							
							// 해당 위치에 기존 세포가 없는 경우
							if (newCell == null) {
								map[y + dy[j]][x + dx[j]] = new Cell(time, time + cell.hp, cell.hp);
								livingCells.add(new int[] {y + dy[j], x + dx[j]});
							} 
							
							// 해당 위치에 기존 세포가 있는 경우
							else {
								// 동일한 시간대에 생성된 세포인 경우 생명력이 큰 세포가 셀 차지
								if(newCell.createdAt == time) {
									if (cell.hp > newCell.hp) {
										newCell.activeAt = time + cell.hp;
										newCell.hp = cell.hp;
									}
								}
							}
						}
					}
					
					// 죽은세포 처리
					if (time >= cell.activeAt + cell.hp) {
						livingCells.remove(i);
						continue;
					}
				}
				
				time++;
			}
			
			sb.append(livingCells.size()).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static class Cell {
		int createdAt;
		int activeAt;
		int hp;
		
		Cell(int createdAt, int activeAt, int hp) {
			this.createdAt = createdAt;
			this.activeAt = activeAt;
			this.hp = hp;
		}
		
		@Override
		public String toString() {
			return "Cell [createdAt=" + createdAt + ", activeAt=" + activeAt + ", hp=" + hp + "]";
		}
	}
}
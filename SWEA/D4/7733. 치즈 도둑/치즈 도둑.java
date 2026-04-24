import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int n,max;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for(int tc = 1; tc<=t; tc++){
            n = Integer.parseInt(br.readLine().trim());
            map = new int[n][n];
            visited = new boolean[n][n];
            max = 0;
            for(int i = 0; i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for(int j = 0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int day = 0;

            while(day<=100){


                for(int i = 0; i<n; i++){
                    for(int j = 0; j<n; j++){
                        if(map[i][j] == day){
                            visited[i][j] = true;
                        }
                    }
                }

                find();
                day++;
            }
            System.out.println("#"+tc +" "+ max);

        }
    }
    public static void find(){
        boolean[][] visitedCopy = new boolean[n][n];

        for(int i = 0; i<n; i++){
            visitedCopy[i] = visited[i].clone();
        }

        int count = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(!visitedCopy[i][j]){
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    visitedCopy[i][j] = true;
                    while(!q.isEmpty()){
                        int tmp[] = q.poll();
                        int x = tmp[0];
                        int y = tmp[1];

                        for(int d = 0; d<4; d++){
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if(nx <0 || ny < 0 || nx >= n || ny >= n || visitedCopy[nx][ny]) continue;

                            visitedCopy[nx][ny] = true;
                            q.add(new int[]{nx,ny});

                        }

                    }
                }
            }
        }
        max = Math.max(max, count);

    }

}
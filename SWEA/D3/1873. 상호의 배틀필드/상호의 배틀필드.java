import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int h, w, stX, stY;
    static char[][] map;
    static char[] input;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            for (int i = 0; i < h; i++) {
                String s = br.readLine().trim();
                for (int j = 0; j < w; j++) {
                    map[i][j] = s.charAt(j);
                }
            }
            int n = Integer.parseInt(br.readLine().trim());
            input = new char[n];
            String s = br.readLine().trim();
            for (int i = 0; i < n; i++) {
                input[i] = s.charAt(i);
            }
            bfs();
            System.out.print("#" + tc + " ");
            for (int i = 0; i < h; i++) {
                for(int j = 0; j<w; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        // ^ : 0,  v : 1, < : 2, > : 3
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == '>') {
                    q.add(new int[]{i, j, 3, 0}); // x, y, 방향, 명령어 인덱스
                    break;
                } else if (map[i][j] == '<') {
                    q.add(new int[]{i, j, 2, 0}); // x, y, 방향, 명령어 인덱스
                    break;
                } else if (map[i][j] == 'v') {
                    q.add(new int[]{i, j, 1, 0}); // x, y, 방향, 명령어 인덱스
                    break;
                } else if (map[i][j] == '^') {
                    q.add(new int[]{i, j, 0, 0}); // x, y, 방향, 명령어 인덱스
                    break;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            int dir = tmp[2];

            if(tmp[3] == input.length){
                break;
            }

            int ex = input[tmp[3]];


            if (ex == 'S') {

                int nx = x + dx[dir];
                int ny = y + dy[dir];
                while (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                    if (map[nx][ny] == '#') {
                        break;
                    } else if (map[nx][ny] == '*') {
                        map[nx][ny] = '.';
                        break;
                    }
                    nx += dx[dir];
                    ny += dy[dir];
                }
                q.add(new int[]{x, y, dir, tmp[3] + 1});
            } else if (ex == 'U') {
                int nx = x + dx[0];
                int ny = y + dy[0];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '.') {
                    map[x][y] = '.';
                    map[nx][ny] = '^';
                    q.add(new int[]{nx, ny, 0, tmp[3] + 1});
                }else{
                    map[x][y] = '^';
                    q.add(new int[]{x,y,0,tmp[3]+1});
                }
            } else if (ex == 'D') {
                int nx = x + dx[1];
                int ny = y + dy[1];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '.') {
                    map[x][y] = '.';
                    map[nx][ny] = 'v';
                    q.add(new int[]{nx, ny, 1, tmp[3] + 1});
                }else{
                    map[x][y] = 'v';
                    q.add(new int[]{x,y,1,tmp[3]+1});
                }
            } else if (ex == 'L') {
                int nx = x + dx[2];
                int ny = y + dy[2];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '.') {
                    map[x][y] = '.';
                    map[nx][ny] = '<';
                    q.add(new int[]{nx, ny, 2, tmp[3] + 1});
                }else{
                    map[x][y] = '<';
                    q.add(new int[]{x,y,2,tmp[3]+1});
                }
            } else if (ex == 'R') {
                int nx = x + dx[3];
                int ny = y + dy[3];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '.') {
                    map[x][y] = '.';
                    map[nx][ny] = '>';
                    q.add(new int[]{nx, ny, 3, tmp[3] + 1});
                }else{
                    map[x][y] = '>';
                    q.add(new int[]{x,y,3,tmp[3]+1});
                }
            }


        }

    }


}
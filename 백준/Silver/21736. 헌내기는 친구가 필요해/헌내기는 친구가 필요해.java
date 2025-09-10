
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static char[][] arr;
    static boolean[][] visited;
    static int startX;
    static int startY;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i<n; i++){
            String line = br.readLine();
            for(int j = 0; j<m; j++){
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == 'I'){
                    startX = i;
                    startY = j;
                }
            }
        }
        dfs(startX, startY);
        if(cnt == 0){
            bw.write("TT\n");
        }
        else{
            bw.write(cnt + "\n");
        }
        bw.flush();
    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        if(arr[x][y] == 'P') cnt++;
        if(x+1 <n && arr[x+1][y] != 'X' && !visited[x+1][y]){
            dfs(x+1, y);
        }

        if(x-1 >= 0 && arr[x-1][y] != 'X' && !visited[x-1][y]){
            dfs(x-1, y);
        }
        if(y+1 <m && arr[x][y+1] != 'X' && !visited[x][y+1]){
            dfs(x, y+1);
        }
        if(y-1 >= 0 && arr[x][y-1] != 'X' && !visited[x][y-1]){
            dfs(x, y-1);
        }
    }
}

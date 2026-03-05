import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, r, c, idx, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        ans = 0;
        idx = 0;

        dfs((int) Math.pow(2, n), 0, 0);
        System.out.println(ans);
    }

    static void dfs(int size, int x, int y) {
        if (x == r && y == c) {
            ans = idx;
            return;
        }
        if (size == 1) {
            idx++;
            return;
        }

        int nSize = size / 2;
        if (r >= x  && r<x+size && c<y+size && c >= y) {
            dfs(nSize, x, y);
            dfs(nSize, x, y + nSize);
            dfs(nSize, x + nSize, y);
            dfs(nSize, x + nSize, y + nSize);
        } else{
            idx += size*size;
        }
    }

}
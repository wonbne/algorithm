import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int m;
    static List<Integer>[] list;
    static boolean[] friend;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            list = new ArrayList[n + 1];
            friend = new boolean[n + 1];
            int count = 0;
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }
            friend[1] = true;
            for (int k : list[1]) {
                if (!friend[k]) {
                    friend[k] = true;
                    count++;
                }
                for (int q : list[k]) {
                    if (!friend[q]) {
                        friend[q] = true;
                        count++;
                    }
                }
            }
            System.out.println("#" + tc + " " + count);
        }
    }
}

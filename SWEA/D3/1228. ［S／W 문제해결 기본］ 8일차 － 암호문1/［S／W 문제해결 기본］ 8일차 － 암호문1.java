import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < m; i++) {
                String s = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int j = 0; j < y; j++) {
                    tmp.add(Integer.parseInt(st.nextToken()));
                }
                list.addAll(x, tmp);
            }
            sb.append("#" + tc + " ");
            for (int k = 0; k<10; k++) {
                sb.append(list.get(k) + " ");
            }
            System.out.println(sb);
        }
    }
}
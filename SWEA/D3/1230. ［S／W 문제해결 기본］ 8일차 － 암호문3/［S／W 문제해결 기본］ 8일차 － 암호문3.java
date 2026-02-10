import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            LinkedList<Integer> list = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < m; i++) {
                String s = st.nextToken();
                switch (s) {
                    case "I":
                        LinkedList<Integer> tmp = new LinkedList<>();
                        int x = Integer.parseInt(st.nextToken());
                        int y = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < y; j++) {
                            tmp.add(Integer.parseInt(st.nextToken()));
                        }
                        list.addAll(x, tmp);
                        break;
                    case "D":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for (int j = x; j < x + y; j++) {
                            list.remove(j);
                        }
                        break;
                    case "A":
                        y = Integer.parseInt(st.nextToken());
                        for(int j = 0; j<y; j++){
                            list.add(Integer.parseInt(st.nextToken()));
                        }
                        break;
                }

            }
            sb.append("#" + tc + " ");
            for (int k = 0; k < 10; k++) {
                sb.append(list.get(k) + " ");
            }
            System.out.println(sb);
        }
    }
}
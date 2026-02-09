import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int t = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<Integer> queue = new ArrayDeque<>(); // 큐 생성
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }
            int minus = 1;
            while (queue.peekLast() != 0) {
                int tmp = queue.poll();
                if (tmp - minus <= 0) {
                    queue.add(0);
                } else {
                    queue.add(tmp - minus);
                }
                minus++;
                if (minus == 6) {
                    minus = 1;
                }
            }

            sb.append("#" + tc);
            for (int a : queue) {
                sb.append(" " + queue.poll());
            }
            System.out.println(sb);
        }

    }
}
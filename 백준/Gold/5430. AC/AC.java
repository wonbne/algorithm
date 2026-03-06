import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public interface Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            Deque<Integer> deque = new ArrayDeque<>();
            String p = br.readLine().trim();
            int n = Integer.parseInt(br.readLine());

            String s = br.readLine().trim();
            if (n > 0) {
                String[] sub = s.substring(1, s.length() - 1).split(",");
                for (String tmp : sub) {
                    deque.add(Integer.parseInt(tmp));
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");
            int dir = 1; // 1 : 정방향, -1 : 역방향, 0 : 에러
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                if (c == 'R') {
                    dir = -dir;
                } else if (c == 'D') {
                    if (deque.isEmpty()) {
                        dir = 0;
                        break;
                    }
                    if (dir == 1) {
                        deque.removeFirst();
                    } else if (dir == -1) {
                        deque.removeLast();
                    }
                }
            }
            if (dir == 0) {
                System.out.println("error");
                continue;
            }
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if (dir == 1 && !deque.isEmpty()) {
                    sb.append(deque.pollFirst());
                } else if (dir == -1 && !deque.isEmpty()) {
                    sb.append(deque.pollLast());
                }

                if (!deque.isEmpty()) {
                    sb.append(",");
                }
            }
            sb.append("]");
            System.out.println(sb);
        }
    }
}

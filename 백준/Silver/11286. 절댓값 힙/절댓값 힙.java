import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b))
                return a - b;
            return Math.abs(a) - Math.abs(b);
        });
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine().trim());
            if (tmp != 0) {
                queue.add(tmp);
            } else {
                if (!queue.isEmpty()) {
                    System.out.println(queue.poll());
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
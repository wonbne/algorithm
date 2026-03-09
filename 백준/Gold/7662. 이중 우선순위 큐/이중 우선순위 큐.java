import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine().trim());
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                String ch = st.nextToken();
                int data = Integer.parseInt(st.nextToken());
                if (ch.equals("I")) {
                    map.put(data, map.getOrDefault(data, 0) + 1);
                    maxQueue.add(data);
                    minQueue.add(data);
                } else {
                    // -1은 최솟값 삭제
                    if (data == -1) {
                        while (!minQueue.isEmpty() && map.getOrDefault(minQueue.peek(), 0) == 0) {
                            minQueue.poll();
                        }
                        if (!minQueue.isEmpty()) {
                            int val = minQueue.poll();
                            map.put(val, map.get(val) - 1);
                        }
                        // 1은 최댓값 삭제
                    } else {
                        while (!maxQueue.isEmpty() && map.getOrDefault(maxQueue.peek(), 0) == 0) {
                            maxQueue.poll();
                        }
                        if (!maxQueue.isEmpty()) {
                            int val = maxQueue.poll();
                            map.put(val, map.get(val) - 1);
                        }
                    }
                }

            }
            while (!minQueue.isEmpty() && map.getOrDefault(minQueue.peek(), 0) == 0) {
                minQueue.poll();
            }

            while (!maxQueue.isEmpty() && map.getOrDefault(maxQueue.peek(), 0) == 0) {
                maxQueue.poll();
            }
            if (minQueue.isEmpty() || maxQueue.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(maxQueue.peek() + " " + minQueue.peek());
            }
        }
    }
}

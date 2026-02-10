import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int k = 1; k <= tc; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Deque<Integer> blue = new ArrayDeque<>();
            Deque<Integer> orange = new ArrayDeque<>();
            Deque<Character> turn = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                char c = st.nextToken().charAt(0);
                if (c == 'B') {
                    turn.add(c);
                    blue.add(Integer.parseInt(st.nextToken()));
                } else {
                    turn.add(c);
                    orange.add(Integer.parseInt(st.nextToken()));
                }
            }

            int posB = 1;
            int posO = 1;
            int time = 0;
            while (!turn.isEmpty()) {
                if (turn.peekFirst() == 'B') {
                    if (orange.peekFirst() != null) {
                        if (posO > orange.peekFirst()) {
                            posO -= Math.min(Math.abs(posB - blue.peekFirst()) + 1,
                                    Math.abs(posO - orange.peekFirst()));
                        } else {
                            posO += Math.min(Math.abs(posB - blue.peekFirst()) + 1,
                                    Math.abs(posO - orange.peekFirst()));
                        }
                    }
                    time += Math.abs(posB - blue.peekFirst()) + 1;
                    posB = blue.peekFirst();

                    blue.pollFirst();
                    turn.pollFirst();
                } else {
                    if (blue.peekFirst() != null) {
                        if (posB > blue.peekFirst()) {
                            posB -= Math.min(Math.abs(posO - orange.peekFirst())+1, Math.abs(posB - blue.peekFirst()));
                        } else {
                            posB += Math.min(Math.abs(posO - orange.peekFirst())+1, Math.abs(posB - blue.peekFirst()));
                        }
                    }
                    time += Math.abs(posO - orange.peekFirst()) + 1;
                    posO = orange.peekFirst();

                    orange.pollFirst();
                    turn.pollFirst();
                }
            }
            System.out.println("#" + k + " " + time);
        }
    }
}
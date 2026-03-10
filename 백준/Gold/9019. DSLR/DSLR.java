import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int a;
    static int b;
    static String s;
    static int min;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            s = "";
            min = Integer.MAX_VALUE;
            visited = new boolean[10000];
            bfs(a);
            System.out.println(s);
        }

    }

    static void bfs(int a) {
        Queue<Node> queue = new LinkedList<>();
        visited[a] = true;
        queue.offer(new Node(a, 0, ""));
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            int nA = tmp.a;
            int count = tmp.c;
            String str = tmp.s;

            if (nA == b) {
                if (count < min) {
                    min = count;
                    s = str;
                }
                continue;
            }

            if (count >= min)
                continue;

            int d = nA * 2 > 9999 ? nA * 2 % 10000 : nA * 2;
            int s = nA == 0 ? 9999 : nA - 1;
            int l = (nA % 1000) * 10 + (nA / 1000);
            int r = (nA / 10) + (nA % 10) * 1000;

            int[] arr = { d, s, l, r };
            for (int i = 0; i < 4; i++) {
                if (!visited[arr[i]]) {
                    if (i == 0) {
                        visited[arr[i]] = true;
                        queue.offer(new Node(arr[i], count + 1, str + "D"));
                    } else if (i == 1) {
                        visited[arr[i]] = true;
                        queue.offer(new Node(arr[i], count + 1, str + "S"));
                    } else if (i == 2) {
                        visited[arr[i]] = true;
                        queue.offer(new Node(arr[i], count + 1, str + "L"));
                    } else if (i == 3) {
                        visited[arr[i]] = true;
                        queue.offer(new Node(arr[i], count + 1, str + "R"));

                    }
                }
            }
        }

    }

    public static class Node {
        int a;
        int c;
        String s;

        public Node(int a, int c, String s) {
            this.a = a;
            this.c = c;
            this.s = s;
        }
    }

}

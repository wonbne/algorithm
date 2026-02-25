import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static int[] arr;
    static Set<String>[] visited;
    static int n;
    static int k;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            String num = st.nextToken();
            n = num.length();
            arr = new int[n];
            max = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = num.charAt(i) - '0';
            }
            k = Integer.parseInt(st.nextToken());
            visited = new HashSet[k+1];
            for(int i = 0; i<=k; i++){
                visited[i] = new HashSet<>();
            }
            dfs(0);
            System.out.println("#" + tc + " " + max);
        }
    }

    public static void dfs(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        if (count == k) {
            max = Math.max(max, Integer.parseInt(sb.toString()));
            return;
        }
        if (visited[count].contains(sb.toString())) {
            return;
        }
        visited[count].add(sb.toString());

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(i, j);
                dfs(count + 1);
                swap(i, j);
            }
        }

    }

    public static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");
            List<Integer> tree = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int op = Integer.parseInt(st.nextToken());
                if (op == 1) {
                    int val = Integer.parseInt(st.nextToken());
                    tree.add(val);
                    int index = tree.size() - 1;
                    while (index > 0) {
                        if (tree.get((index-1)/2) >= tree.get(index))
                            break;

                        int tmp = tree.get((index - 1) / 2);
                        tree.set((index - 1) / 2, tree.get(index));
                        tree.set(index, tmp);
                        index = (index - 1) / 2;
                    }
                } else if (op == 2) {
                    if (tree.size() == 0) {
                        sb.append(-1 + " ");
                        continue;
                    }
                    int val = tree.get(0);
                    sb.append(val + " ");

                    int last = tree.remove(tree.size() - 1);

                    if(tree.size() == 0) continue;

                    tree.set(0, last);
                    int idx = 0;
                    while (true) {
                        int left = idx * 2 + 1;
                        int right = idx * 2 + 2;
                        int bigger = idx;
                        if (left < tree.size() && tree.get(bigger) < tree.get(left)) {
                            bigger = left;
                        }
                        if (right < tree.size() && tree.get(bigger) < tree.get(right)) {
                            bigger = right;
                        }
                        if (bigger == idx)
                            break;

                        int tmp = tree.get(idx);
                        tree.set(idx, tree.get(bigger));
                        tree.set(bigger, tmp);

                        idx = bigger;
                    }
                }
            }
            System.out.println(sb);

        }

    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] parent;
    static List<Integer> know;
    static List<Integer>[] party;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        party = new ArrayList[m];
        know = new ArrayList<>();
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
        }
        // 진실을 아는 사람들 추가
        st = new StringTokenizer(br.readLine().trim());
        int size = Integer.parseInt(st.nextToken());
        if(size == 0){
            System.out.println(m);
            return;
        }
        for (int i = 0; i < size; i++) {
            know.add(Integer.parseInt(st.nextToken()));
            if (i == 0)
                continue;
            union(know.get(i), know.get(i - 1));
        }

        // 파티 정보 입력 및 유니온
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int s = Integer.parseInt(st.nextToken());
            for (int j = 0; j < s; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
            for (int j = 0; j < s - 1; j++) {
                union(party[i].get(j), party[i].get(j + 1));
            }

        }

        // 과장 가능한 파티 체크
        int count = 0;
        for (int i = 0; i < m; i++) {
            boolean check = true;
            for (int j = 0; j < party[i].size(); j++) {
                if (find(party[i].get(j)) == find(know.get(0))) {
                    check = false;
                    break;
                }
            }
            if (check)
                count++;
        }

        // 출력
        System.out.println(count);
    }

    public static void union(int a, int b) {
        parent[find(b)] = find(a);
    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
}
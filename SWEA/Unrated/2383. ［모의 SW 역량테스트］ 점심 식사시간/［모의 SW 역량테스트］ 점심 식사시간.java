import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static int n;
    static List<Person> p;
    static List<Stair> s;
    static int min;
    static List<Integer> time1;
    static List<Integer> time2;

    public static class Person {
        int i;
        int j;
        int s1;
        int s2;

        public Person(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static class Stair {
        int i;
        int j;
        int count;
        List<Integer> endTime = new ArrayList<>();

        public Stair(int i, int j, int count) {
            this.i = i;
            this.j = j;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine().trim());
            arr = new int[n][n];
            p = new ArrayList<>();
            s = new ArrayList<>();
            min = Integer.MAX_VALUE;
            time1 = new ArrayList<>();
            time2 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < n; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    arr[i][j] = tmp;
                    if (tmp == 1) {
                        p.add(new Person(i, j));
                    } else if (tmp != 1 && tmp != 0) {
                        s.add(new Stair(i, j, tmp));
                    }
                }
            }

            for (int i = 0; i < p.size(); i++) {
                p.get(i).s1 = Math.abs(s.get(0).i - p.get(i).i) + Math.abs(s.get(0).j - p.get(i).j);
                p.get(i).s2 = Math.abs(s.get(1).i - p.get(i).i) + Math.abs(s.get(1).j - p.get(i).j);
            }
            dfs(0);
            System.out.println("#" + tc + " " + min);
        }
    }

    public static void dfs(int count) {
        if (count == p.size()) {
            List<Integer> temp1 = new ArrayList<>(time1);
            List<Integer> temp2 = new ArrayList<>(time2);
            Collections.sort(temp1);
            Collections.sort(temp2);

            List<Integer> end1 = new ArrayList<>();
            for (int i = 0; i < temp1.size(); i++) {
                int arrival = temp1.get(i) + 1; // 도착 1분 후 진입 대기
                if (i >= 3) {
                    arrival = Math.max(arrival, end1.get(i - 3));
                }
                end1.add(arrival + s.get(0).count);
            }

            // 계단 2번 계산
            List<Integer> end2 = new ArrayList<>();
            for (int i = 0; i < temp2.size(); i++) {
                int arrival = temp2.get(i) + 1;
                if (i >= 3) {
                    arrival = Math.max(arrival, end2.get(i - 3));
                }
                end2.add(arrival + s.get(1).count);
            }

            int last1 = end1.isEmpty() ? 0 : end1.get(end1.size() - 1);
            int last2 = end2.isEmpty() ? 0 : end2.get(end2.size() - 1);

            min = Math.min(min, Math.max(last1, last2));
            return;
        }

        Person person = p.get(count);

        // 1번 계단 선택
        time1.add(person.s1);
        dfs(count + 1);
        time1.remove(time1.size() - 1);

        // 2번 계단 선택
        time2.add(person.s2);
        dfs(count + 1);
        time2.remove(time2.size() - 1);
    }
}
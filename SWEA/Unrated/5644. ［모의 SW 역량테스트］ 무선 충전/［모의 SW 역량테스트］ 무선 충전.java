import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static int m;
    static int a;
    static Charger[] cArr;
    static int[] move1;
    static int[] move2;
    static int totalSum;
    static int m1X;
    static int m1Y;
    static int m2X;
    static int m2Y;

    public static class Charger {
        int x;
        int y;
        int c;
        int p;

        public Charger(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            m = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            cArr = new Charger[a];
            arr = new int[11][11];
            move1 = new int[m];
            move2 = new int[m];
            totalSum = 0;
            m1X = 1;
            m1Y = 1;
            m2X = 10;
            m2Y = 10;
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < m; i++) {
                move1[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < m; i++) {
                move2[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < a; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                cArr[i] = new Charger(x, y, c, p);
            }
            move();
            System.out.println("#"+tc+" "+ totalSum);
        }
    }

    public static void move() {
        int idx = 0;
        cal();
        // 0: 이동 안함, 1: 상, 2: 우, 3: 하, 4: 좌
        while (idx < m) {
            if (move1[idx] == 0) {

            } else if (move1[idx] == 1) {
                m1Y -= 1;
            } else if (move1[idx] == 2) {
                m1X += 1;
            } else if (move1[idx] == 3) {
                m1Y += 1;
            } else if (move1[idx] == 4) {
                m1X -= 1;
            }

            if (move2[idx] == 0) {


            } else if (move2[idx] == 1) {
                m2Y -= 1;
            } else if (move2[idx] == 2) {
                m2X += 1;
            } else if (move2[idx] == 3) {
                m2Y += 1;
            } else if (move2[idx] == 4) {
                m2X -= 1;
            }
            cal();
            idx++;
        }
    }

    public static void cal() {
        int sumMax = 0;

        for (Charger c1 : cArr) {
            for (Charger c2 : cArr) {
                int aSum = 0;
                int bSum = 0;
                int sum = 0;
                if (check(c1.x, c1.y, c1.c, m1X, m1Y))
                    aSum += c1.p;
                if (check(c2.x, c2.y, c2.c, m2X, m2Y))
                    bSum += c2.p;
                if (c1 == c2 && check(c1.x, c1.y, c1.c, m1X, m1Y) && check(c2.x, c2.y, c2.c, m2X, m2Y)) {
                    sum = c1.p;
                } else {
                    sum += aSum + bSum;
                }
                sumMax = Math.max(sumMax, sum);
            }
        }
        totalSum += sumMax;
    }

    public static boolean check(int cX, int cY, int c, int nX, int nY) {
        if (Math.abs(cX - nX) + Math.abs(cY - nY) <= c) {
            return true;
        } else {
            return false;
        }
    }
}
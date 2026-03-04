import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static class Community {
        int x;
        int y;
        int count;
        int dir;

        public Community(int x, int y, int count, int dir) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.dir = dir;
        }
    }

    static int n; // 셀의 개수
    static int m; // 격리 시간
    static int k; // 군집의 개수
    static Community[] cArr;
    static int[][] arr;
    static List<Community>[][] cList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            cArr = new Community[k];
            arr = new int[n][n];
            cList = new ArrayList[n][n];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                cArr[i] = new Community(x, y, c, d);
            }
            move();
            int sum = 0;
            for (Community c : cArr) {
                sum += c.count;
            }
            System.out.println("#" + tc + " " + sum);
        }
    }

    public static void move() {
        int idx = 0;
        // 상 : 1, 하 : 2, 좌 : 3, 우 : 4
        while (idx < m) {
            for (Community c : cArr) {
                if (c.count == 0)
                    continue;
                if (c.dir == 1) {
                    c.x -= 1;
                } else if (c.dir == 2) {
                    c.x += 1;
                } else if (c.dir == 3) {
                    c.y -= 1;
                } else if (c.dir == 4) {
                    c.y += 1;
                }
            }

            for (Community c : cArr) {
                if (c.x == 0 || c.y == 0 || c.x == n - 1 || c.y == n - 1) {
                    if (c.count == 0)
                        continue;
                    c.count /= 2;
                    switch (c.dir) {
                        case 1:
                            c.dir = 2;
                            break;
                        case 2:
                            c.dir = 1;
                            break;
                        case 3:
                            c.dir = 4;
                            break;
                        case 4:
                            c.dir = 3;
                            break;
                    }
                }
            }
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    cList[i][j] = new ArrayList<>();
                }
            }
            for(Community c : cArr){
                if(c.count>0) cList[c.x][c.y].add(c);
            }
            cal();
            idx++;
        }
    }

    public static void cal() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(cList[i][j].size() <= 1) continue;


                int sum = 0;
                int maxCount = 0;
                Community maxC = null;
                for(Community c : cList[i][j]){
                    sum += c.count;
                    if(c.count>maxCount){
                        maxCount = c.count;
                        maxC = c;
                    }
                }
                maxC.count = sum;
                for(Community c : cList[i][j]){
                    if(c != maxC){
                        c.count = 0;
                    }
                }

            }
        }

        // for (int i = 0; i < cArr.length - 1; i++) {
        // if(cArr[i].count == 0) continue;
        // for (int j = i + 1; j < cArr.length; j++) {
        // if (cArr[i].x == cArr[j].x && cArr[i].y == cArr[j].y) {
        // if (cArr[i].count > cArr[j].count) {
        // cArr[i].count += cArr[j].count;
        // cArr[j].dir = 0;
        // } else {
        // cArr[j].count += cArr[i].count;
        // cArr[i].dir = 0;
        // }
        // }
        // }
        // }
    }

}
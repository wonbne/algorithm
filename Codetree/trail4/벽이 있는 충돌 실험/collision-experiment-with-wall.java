import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;

    // 상 우 하 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static Set<Point> set = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        for(int tc = 1; tc <= t; tc++){

            set.clear();

            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            for(int i = 1; i <= m; i++){

                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                char td = st.nextToken().charAt(0);

                int d = 0;

                if(td == 'U'){
                    d = 0;
                } else if(td == 'R'){
                    d = 1;
                } else if(td == 'D'){
                    d = 2;
                } else{
                    d = 3;
                }

                set.add(new Point(x, y, d));
            }

            for(int i = 0; i < 4 * n; i++){
                move();
            }

            System.out.println(set.size());
        }
    }

    public static void move(){

        Queue<Point> q = new LinkedList<>();

        for(Point p : set){

            int nx = p.x + dx[p.dir];
            int ny = p.y + dy[p.dir];

            if(nx <= 0 || ny <= 0 || nx > n || ny > n){

                q.add(new Point(p.x, p.y, (p.dir + 2) % 4));

            } else{

                q.add(new Point(nx, ny, p.dir));
            }
        }

        set.clear();

        // 충돌 제거용
        Set<Point> removeSet = new HashSet<>();

        while(!q.isEmpty()){

            Point tp = q.poll();

            if(set.contains(tp)){

                removeSet.add(tp);

            } else{

                set.add(tp);
            }
        }

        // 충돌한 애들 제거
        for(Point p : removeSet){
            set.remove(p);
        }
    }

    public static class Point{

        int x;
        int y;
        int dir;

        public Point(int x, int y, int dir){

            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        @Override
        public boolean equals(Object o) {

            if(this == o) return true;

            if(!(o instanceof Point)) return false;

            Point point = (Point) o;

            // 위치만 같으면 충돌
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, maxT, count;
    static List<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        list = new ArrayList<>();
        maxT = 0;
        count = 0;
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            maxT = Math.max(maxT, d);
            list.add(new int[]{d,w});
        }
        list.sort((a,b) -> Integer.compare(b[0],a[0]));

        find();
        System.out.println(count);

    }
    public static void find(){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int time = maxT;
        int idx = 0;
        while(time>=1){
            while(idx<n && list.get(idx)[0]>=time){
                pq.add(list.get(idx)[1]);
                idx++;
            }

            if(!pq.isEmpty()) count += pq.poll();

            time--;
        }
    }
}
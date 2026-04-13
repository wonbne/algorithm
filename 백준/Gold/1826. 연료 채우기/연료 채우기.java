import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, l, p, count;
    static List<int[]> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        arr = new ArrayList<>();
        count = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr.add(new int[]{a, b});
        }
        arr.sort((a,b) -> Integer.compare(a[0],b[0]));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        l = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        System.out.println(find());
    }

    public static int find(){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int idx = 0;
        int fuel = p;
        while(fuel < l){
            while(idx <n && arr.get(idx)[0] <= fuel){
                pq.add(arr.get(idx)[1]);
                idx++;
            }

            if(pq.isEmpty()) return -1;

            fuel += pq.poll();
            count++;
        }
        return count;

    }
}
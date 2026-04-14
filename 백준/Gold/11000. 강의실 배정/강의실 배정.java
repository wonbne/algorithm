import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, maxT;
    static long count;
    static List<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        list = new ArrayList<>();
        maxT = 0;
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            maxT = Math.max(maxT, t);
            list.add(new int[]{s,t});
        }
        list.sort((a,b) -> Integer.compare(a[0],b[0]));
        System.out.println(find());
    }

    public static int find(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(list.get(0)[1]);
        for(int i = 1; i<n; i++){
            if(pq.peek() <= list.get(i)[0]){
                pq.poll();
            }

            pq.add(list.get(i)[1]);
        }
        return pq.size();

    }
}
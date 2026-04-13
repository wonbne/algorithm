import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,k;
    static long result;
    static List<int[]> list;
    static int[] bag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bag = new int[k];
        list = new ArrayList<>();
        result = 0;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new int[]{m,v});
        }
        for(int i = 0; i<k; i++){
            bag[i] = Integer.parseInt(br.readLine().trim());
        }
        list.sort((a,b)->Integer.compare(a[0],b[0]));
        Arrays.sort(bag);
        find();
        System.out.println(result);
    }
    public static void find(){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        for(int i = 0; i<k; i++){
            while(idx<n && bag[i] >= list.get(idx)[0]){
                pq.add(list.get(idx)[1]);
                idx++;
            }

            if(!pq.isEmpty()){
                result += pq.poll();
            }
        }

    }
}
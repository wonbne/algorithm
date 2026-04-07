import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int n;
    static double e;
    static int[] parent;
    static boolean[] visited;
    static double total;
    static int[] xArr, yArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            total = 0;
            n = Integer.parseInt(br.readLine().trim());
            parent = new int[n+1];
            visited = new boolean[n+1];
            for(int i = 0; i<=n; i++){
                parent[i] = i;
            }

            xArr = new int[n+1];
            yArr = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int i = 1; i <= n; i++) {
                xArr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 1; i <= n; i++) {
                yArr[i] = Integer.parseInt(st.nextToken());
            }
            e = Double.parseDouble(br.readLine().trim());


            prim();
            System.out.println("#"+tc+" "+ Math.round(total));
        }
    }

    public static void prim(){
        PriorityQueue<long[]> queue = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        queue.add(new long[]{1,0});
        int count = 0;
        while(!queue.isEmpty()){
            long[] tmp = queue.poll();
            long start = tmp[0];
            long weight = tmp[1];
            if(visited[(int)start]) continue;
            visited[(int)start] = true;
            total += e * weight;
            count++;
            if(count == n) break;
            for(int next = 1; next<= n; next++){
                if(!visited[next]){
                    long dx = xArr[(int)start] - xArr[next];
                    long dy = yArr[(int)start] - yArr[next];
                    queue.add(new long[]{next, dx*dx + dy*dy});
                }
            }
        }


    }

}
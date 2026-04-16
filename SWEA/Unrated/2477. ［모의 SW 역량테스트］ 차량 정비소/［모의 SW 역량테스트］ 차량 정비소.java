import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int n, m, k, a, b, count;
    static int[] recepT, repairT, arriveTime, recep, repair, used, recepEnd, repairEnd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            count = 0;
            recepT = new int[n + 1];
            repairT = new int[m + 1];
            recep = new int[n + 1];
            repair = new int[m + 1];
            recepEnd = new int[n+1];
            repairEnd = new int[m+1];
            used = new int[k+1];
            arriveTime = new int[k + 1];
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 1; i <= n; i++) {
                recepT[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 1; i <= m; i++) {
                repairT[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 1; i <= k; i++) {
                arriveTime[i] = Integer.parseInt(st.nextToken());
            }
            find();
            if(count == 0) count = -1;
            System.out.println("#"+tc + " " + count);
        }
    }

    public static void find() {
        Queue<Integer> q = new LinkedList<>(); //접수 대기 쿠
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        }); //넘어온 시간, 접수 창구번호, 고객번호

        int time = 0;
        int idx = 1;
        int finish = 0;
        while (true) {
            //접수 대기 넣기
            for (int i = idx; i <= k; i++) {
                if (arriveTime[i] == time) {
                    q.add(i);
                    idx++;
                } else if (arriveTime[i] > time) {
                    break;
                }
            }
            //접수 창구 넣기 & 빼기
            for(int i = 1; i<=n; i++){
                if(recep[i] != 0 && time == recepEnd[i]){
                    pq.add(new int[] {time, i, recep[i]});
                    recep[i] = 0;
                }

                if(!q.isEmpty() && recep[i] == 0){
                    recep[i] = q.poll();
                    recepEnd[i] = time + recepT[i];
                }

            }

            //정비 창구 넣기 & 빼기
            for(int i = 1; i<=m; i++){
                 if(repair[i] != 0 && time == repairEnd[i]){
                    repair[i] = 0;
                    finish++;
                }

                if(!pq.isEmpty() && repair[i] == 0){
                    int[] tmp = pq.poll();
                    repair[i] = tmp[2];
                    repairEnd[i] = time + repairT[i];
                    if(tmp[1] == a && i == b) count += tmp[2];
                }
            }
            time++;
            if(finish == k){
                break;
            }
        }
    }
}
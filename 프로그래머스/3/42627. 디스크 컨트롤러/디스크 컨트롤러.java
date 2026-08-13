import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a,b) -> a[0]-b[0]);
        
        // 0은 순서, 1은 요청되는 시점, 2는 소요시간
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a,b) ->{
            if(a[2] != b[2]){
                return a[2] - b[2];
            }
            
            if(a[1] != b[1]){
                return a[1] - b[1];
            }
            
            return a[0] - b[0];
        });
        
        

        
        int time = 0;
        int idx = 0;
        
        while(idx < jobs.length || !pq.isEmpty()){
            
            while(idx<jobs.length && jobs[idx][0] <= time){
                int[] tmp = new int[3];
                
                tmp[0] = idx;
                tmp[1] = jobs[idx][0];
                tmp[2] = jobs[idx][1];
            
                pq.add(tmp);
                idx++;
            }
            
            if(pq.isEmpty()){
                time = jobs[idx][0];
                continue;
            }
            
            int[] tmp = pq.poll();
            
            time = Math.max(time, tmp[1]);
            
            time += tmp[2];
            
            answer += time - tmp[1];
        }
        
        
        return answer / jobs.length;
    }
}
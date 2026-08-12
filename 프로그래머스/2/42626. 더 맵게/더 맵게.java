import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
    
        while(true){
            
            if(pq.size() >=2 && pq.peek()<K){
                int f = pq.poll();
                int s = pq.poll();
                
                pq.add(f+s*2);
                answer++;
            } else{
                if(pq.peek() < K){
                    return -1;
                }
                break;
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i<bridge_length; i++){
            q.offer(0);
        }
        
        int idx = 0;
        int sum = 0;
        int time = 0;
        while(true){
            time++;
            int poll = q.poll();
            if(poll != 0){
                sum -= poll;
            }
            
            if(idx == truck_weights.length && sum == 0){
                break;
            }
            
            if(idx<truck_weights.length && sum+truck_weights[idx] <= weight){
                sum += truck_weights[idx];
                q.offer(truck_weights[idx]);
                idx++;
            } else{
                q.offer(0);
            }
            
        }
        
        
        answer = time;
        
        return answer;
    }
}
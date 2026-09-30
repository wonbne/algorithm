import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i = 0; i<works.length; i++){
            pq.offer(works[i]);
        }
        
        while(n>0){
            int tmp = pq.poll();
            if(tmp == 0) break;
            tmp--;
            n--;
            pq.offer(tmp);
        }
        
        while(!pq.isEmpty()){
            int tmp = pq.poll();
            answer += tmp*tmp;
        }
        
        return answer;
    }
}
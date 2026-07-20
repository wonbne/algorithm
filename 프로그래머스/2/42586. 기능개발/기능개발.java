import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;
        for(int p : progresses){
            int day = (int)Math.ceil((100 - p) / (double)speeds[i++]);
            queue.add(day);
        }

        int max = queue.poll();
        
        int count = 1;
        
        List<Integer> list = new ArrayList<>();
    
        
        for(int p : queue){
            if(max < p){
                max = p;
                list.add(count);
                count = 1;
            } else{
                count++;
            }
        }
        
        list.add(count);
        
        int[] answer = new int[list.size()];
        
        int idx = 0;
        
        for(int c : list){
            answer[idx++] = c;
        }
        
        return answer;
    }
}
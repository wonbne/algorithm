import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        
        int size = 0;
        
        for(int i = 0; i<operations.length; i++){
            String[] tmp = operations[i].split(" ");
            
            if(tmp[0].equals("I")){
                pqMin.add(Integer.parseInt(tmp[1]));
                pqMax.add(Integer.parseInt(tmp[1]));
                size++;
            } else{
                
                if(size == 0) continue;
                
                if(tmp[1].equals("-1")){
                    int removed = pqMin.poll();
                    pqMax.remove(removed);
                    size--;
                }else{
                    int removed = pqMax.poll();
                    pqMin.remove(removed);
                    size--;
                }

                
            }
               
        }
        
        if(size == 0){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            answer[0] = pqMax.poll();
            answer[1] = pqMin.poll();
        }
        return answer;
    }
}
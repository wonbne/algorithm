import java.util.*;

class Solution {
    static Queue<int[]> q;
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        q = new LinkedList<>();
        
        int idx = 0;
        for(int i = 0; i<priorities.length; i++){
            q.add(new int[]{priorities[i], idx++});
        }
        
        idx = -1;
        int count = 0;
        
        while(idx != location){
            int[] val = q.poll();
            
            if(!check(val[0])){
                q.add(val);
            } else{
                idx = val[1];
                count++;
            }
        }
        
        answer = count;
        
        return answer;
    }
    
    public boolean check(int val){
        List<int[]> list = new ArrayList<>(q);
        
        for(int i = 0; i<list.size(); i++){
            if(val < list.get(i)[0]){
                return false;
            }
        }
        return true;
    }
    
}
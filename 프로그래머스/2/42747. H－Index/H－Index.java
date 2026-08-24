import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        int max = 0;
        
        for(int i = 0; i<citations.length; i++){
            if(citations[i] >= i+1 && citations[i] >= citations.length - i){
                max = Math.max(citations.length - i, max);                
            }
        }
        
        return max;
    }
}
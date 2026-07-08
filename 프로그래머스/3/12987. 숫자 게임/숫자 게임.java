import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idx = 0;
        
        for(int i = 0; i<A.length && idx<B.length; i++){
            if(A[i] < B[idx]){
                idx++;
                answer++;
            } else{
                idx++;
                i--;
            }
        }
        return answer;
    }
}
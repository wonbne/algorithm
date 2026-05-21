import java.util.*;

public class Solution {
    public int solution(int n) {
        int t = n;
        int jump = 0;
        while(t > 0){
            if(t % 2 != 0){
                jump++;
            }
            t /= 2;
        }
                                                                                                                                     
        return jump;
    }
}
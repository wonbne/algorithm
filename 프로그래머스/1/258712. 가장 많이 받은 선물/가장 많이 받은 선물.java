import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i<friends.length; i++){
            map.put(friends[i], i);
        }
        
        int[][] mat = new int[friends.length][friends.length+1];
        
        for(int i = 0; i<gifts.length; i++){
            String[] s = gifts[i].split(" ");
            
            String s1 = s[0];
            String s2 = s[1];
            
            int idx1 = map.get(s1);
            int idx2 = map.get(s2);
            
            mat[idx1][friends.length]++;
            mat[idx2][friends.length]--;
            
            mat[idx1][idx2]++;
        }
        
        
        int[] count = new int[friends.length];
        
        for(int i = 0; i<friends.length; i++){
            for(int j = i+1; j<friends.length; j++){
                if(mat[i][j] > mat[j][i]){
                    count[i]++;
                } else if(mat[i][j] < mat[j][i]){
                    count[j]++;
                } else{
                    if(mat[i][friends.length] > mat[j][friends.length]){
                        count[i]++;
                    } else if(mat[i][friends.length] < mat[j][friends.length]){
                        count[j]++;
                    }
                    
                }
                
            }
        } 
        
        
        
        for(int i = 0; i<count.length; i++){
            answer = Math.max(answer, count[i]);    
        }
        
        
        return answer;
    }
}
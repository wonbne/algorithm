import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        
        int[][] no = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        
        ArrayList<Integer> list = new ArrayList<>();
                      
        int max = 0;
                      
        for(int i = 0; i<3; i++){
            int count = 0;
            for(int j = 0; j<answers.length; j++){
                if(no[i][j%no[i].length] == answers[j]){
                    count++;
                }
            }
            if(max<count){
                max = count;
                list.clear();
                list.add(i+1);
            } else if(max == count){
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];
        
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }
}
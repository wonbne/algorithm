class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        //width * height = brown+yellow
        //(width-2) * (height-2) = yellow
        int width = 0;
        int height = 0;
        
        int total = brown + yellow;
          
        for(height = 3; height<= total; height++){
            
            width = total / height;
            
            if((width-2) * (height-2) == yellow){
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }
        return answer;
    }
}
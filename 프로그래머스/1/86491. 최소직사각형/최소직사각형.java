
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int row = 0;
        int column = 0;
        
        for(int i = 0; i<sizes.length; i++){
            int w = Math.min(sizes[i][0], sizes[i][1]);
            int h = Math.max(sizes[i][0], sizes[i][1]);
            
            row = Math.max(row, w);
            column = Math.max(column, h);
        }
        return row*column;
    }
}
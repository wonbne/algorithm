class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String st = Integer.toString(n, 3);
        answer = Integer.parseInt(new StringBuilder(st).reverse().toString(),3);
        
        return answer;
    }
}
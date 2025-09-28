class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        def(numbers, target, 0, 0);
        return answer;
        
    }
    public void def(int[] numbers, int target, int idx, int sum){
        if(idx == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        
        def(numbers, target, idx+1, sum + numbers[idx]);
        def(numbers, target, idx+1, sum - numbers[idx]);
    }
}
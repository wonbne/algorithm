class Solution {
    
    static int[] memo;
    
    public long solution(int n) {
        
        memo = new int[n+1];
        long answer = dfs(n);
        return answer;
    }
    
    public int dfs(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        if(memo[n] != 0){
            return memo[n];
        }
        
        memo[n] = (dfs(n-1) + dfs(n-2)) % 1234567;
        
        return memo[n];
    }
    
}
class Solution {
    static int answer = 0;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                def(i, n, computers);
                answer++;
            }
        }
        return answer;
    }
    public void def(int node, int n, int[][] computers){
        visited[node] = true;
        for(int i = 0; i<n; i++){
            if(computers[node][i] == 1 && !visited[i]){
                def(i, n, computers);
            }
        }
    }
}
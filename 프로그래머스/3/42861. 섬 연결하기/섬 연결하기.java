import java.util.*;
class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n+1];
        for(int i = 0; i<=n; i++){
            parent[i] = i;
        }
        Arrays.sort(costs,(a,b)->Integer.compare(a[2],b[2]));
        for(int i = 0; i<costs.length; i++){
            if(find(costs[i][0]) != find(costs[i][1])){
                answer += costs[i][2];
                union(costs[i][0], costs[i][1]);
            }
        }
        
        return answer;
    }
    
    public static void union(int a, int b){
        int n1 = find(a);
        int n2 = find(b);
        if(n1 != n2){
            parent[n1] = n2;
        }
    }
    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}

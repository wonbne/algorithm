import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for(int tc = 1; tc<=t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            parent = new int[n+1];
            for(int i = 0; i<=n; i++){
                parent[i] = i;
            }
            for(int i = 0; i<m; i++){
                st = new StringTokenizer(br.readLine().trim());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            }
            Set<Integer> set = new HashSet<>();
            for(int i = 1; i<=n; i++){
                set.add(find(i));
            }
            System.out.println("#"+tc+" "+set.size());
        }
    }

    static void union(int a, int b){
        int n1 = find(a);
        int n2 = find(b);

        parent[n1] = n2;
    }
    static int find(int x){
        if(x == parent[x]){
            return x;
        }
        int root = find(parent[x]);
        parent[x] = root;
        return root;
    }


}
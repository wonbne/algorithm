import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m,k;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i = 1; i<=n; i++){
            parent[i] = i;
        }
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine().trim());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x,y);
        }
        int is = 1;

        st = new StringTokenizer(br.readLine().trim());
        int[] arr = new int[k];
        for(int i = 0; i<k; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<k; i++){
            if(find(arr[i-1]) != find(arr[i])){
                is = 0;
                break;
            }
        }

        System.out.println(is);
    }

    public static void union(int x, int y){
        int n1 = find(x);
        int n2 = find(y);

        parent[n1] = n2;
    }

    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        int root = find(parent[x]);
        parent[x] = root;
        return root;
    }
}

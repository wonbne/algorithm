import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int m = Integer.parseInt(br.readLine().trim());    
        arr = new int[n+1];
        for(int i = 0; i<=n; i++){
            arr[i] = i;
        }
        for(int i = 1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for(int j = 1; j<=n; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1){
                    union(i, j);
                }
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int[] city = new int[m+1];
        for(int i = 1; i<=m; i++){
            city[i] = Integer.parseInt(st.nextToken());
        }
        boolean is = true;
        for(int i = 2; i<=m; i++){
            if(find(city[i-1]) != find(city[i])){
                is = false;
                break;
            }
        }

        System.out.println(is ? "YES":"NO");
    }

    public static int find(int x){
        if(arr[x] == x) return x;
        int root = find(arr[x]);
        arr[x] = root;
        return root;
    }

    public static void union(int a, int b){
        int n1 = find(a);
        int n2 = find(b);
        arr[n1] = n2;
    }
}

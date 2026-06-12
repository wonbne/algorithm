import java.util.Scanner;
public class Main {
    static int k, n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];

        dfs(0,arr);

    }

    public static void dfs(int depth, int[] arr){
        if(depth == n){
            for(int i = 0; i<n; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i<=k; i++){
            if(depth >= 2 && arr[depth-1] == i && arr[depth-2] == i){
                continue;
            }

            arr[depth] = i;
            dfs(depth+1, arr);
        }
    }
}
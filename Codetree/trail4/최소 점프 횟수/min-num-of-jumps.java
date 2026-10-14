import java.util.Scanner;
public class Main {

    static int n,min;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(0, 0);

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        } else{
            System.out.println(min);
        }
    }

    public static void dfs(int idx, int count){

        if(idx >= n){
            return ;
        }

        if(idx == n-1){
            min = Math.min(min, count);
            return ;
        }

        int now = arr[idx];

        for(int i = 1; i<=now; i++){
            dfs(idx+i, count+1);
        }

    }
}
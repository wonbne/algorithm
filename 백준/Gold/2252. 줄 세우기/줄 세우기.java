import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static List<Integer>[] list;
    static int[] indegrees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        indegrees = new int[n+1];
        list = new ArrayList[n+1];
        for(int i = 0; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            indegrees[b]++;
        }
        sort();
    }

    public static void sort(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i<= n; i++){
            if(indegrees[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int now = queue.poll();

            System.out.print(now + " ");
            for(int c : list[now]){

                indegrees[c]--;

                if(indegrees[c] == 0){
                    queue.add(c);
                }
            }

        }
    }
}
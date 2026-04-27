import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _260427Test2 {
    static int n,m,max,maxIdx;
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for(int tc = 1; tc<=t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            visited = new boolean[n+1];
            list = new ArrayList[n+1];
            max = 0;
            maxIdx = 0;
            for(int i = 0; i<=n; i++){
                list[i] = new ArrayList<>();
            }

            for(int i = 0; i<m; i++){
                st = new StringTokenizer(br.readLine().trim());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
            }

            for(int i = 1; i<=n; i++){
                visited[i] = true;
                dfs(i, i, 0);
                visited[i] = false;
            }
            System.out.println("#"+tc+" "+maxIdx);
        }

    }

    public static void dfs(int start, int idx, int count){

        if(max < count){
            max = count;
            maxIdx = start;
        }else if(max == count){
            maxIdx = Math.min(maxIdx, start);
        }


        for(int i : list[idx]){
            if(!visited[i]){
                visited[i] = true;
                dfs(start, i,count+1);
                visited[i] = false;
            }
        }


    }
}

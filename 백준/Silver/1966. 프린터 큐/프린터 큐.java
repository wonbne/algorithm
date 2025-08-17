
import java.io.*;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Doc{
        int idx, pri;
        Doc(int idx, int pri){
            this.idx = idx;
            this.pri = pri;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i<k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<Doc> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                q.offer(new Doc(j, Integer.parseInt(st.nextToken())));
            }
            int p = 0;
            while(!q.isEmpty()){
                Doc d = q.poll();

                int max = 0;
                for(Doc c : q){
                    max = Math.max(max, c.pri);
                }
                if (d.pri >= max) {
                    p++;
                    if (d.idx == m) {
                        sb.append(p).append('\n');
                        break;
                    }
                } else {
                    q.offer(d);
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}

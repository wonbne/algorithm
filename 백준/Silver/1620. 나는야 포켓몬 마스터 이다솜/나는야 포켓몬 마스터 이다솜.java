
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String s = br.readLine();
            list.add(s);
            map.put(s, i);
        }
        for(int i=0; i<m; i++){
            String s = br.readLine();
            if(s.matches("\\d+")){
                bw.write(list.get(Integer.parseInt(s) - 1) + "\n");
            } else{
                bw.write(map.get(s) + 1 + "\n");
            }
        }
        bw.flush();
    }
}

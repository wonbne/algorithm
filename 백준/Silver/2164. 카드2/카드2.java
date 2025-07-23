
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 1; i<=k; i++){
            queue.add(i);
        }
        while(true){
            if(queue.size()==1){
                bw.write(queue.remove()+"\n");
                break;
            }
            else{
                queue.remove();
                queue.add(queue.remove());
            }
        }
        bw.flush();

    }

}

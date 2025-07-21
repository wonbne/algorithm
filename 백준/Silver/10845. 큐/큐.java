
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<k; i++){
            String[] s = br.readLine().split(" ");
            switch(s[0]){
                case "push":
                    list.add(Integer.parseInt(s[1]));
                    break;
                case "pop":
                    if(list.isEmpty()){
                        bw.write("-1\n");
                        break;
                    }
                    bw.write(list.get(0) +"\n");
                    list.remove(0);
                    break;
                case "size":
                    bw.write(list.size()+"\n");
                    break;
                case "empty":
                    if(list.isEmpty()){
                        bw.write("1\n");
                        break;
                    }
                    else{
                        bw.write("0\n");
                        break;
                    }
                case "front":
                    if(list.isEmpty()){
                        bw.write("-1\n");
                        break;
                    }
                    else{
                        bw.write(list.get(0) + "\n");
                        break;
                    }
                case "back":
                    if(list.isEmpty()){
                        bw.write("-1\n");
                        break;
                    }
                    else{
                        bw.write(list.get(list.size()-1) + "\n");
                        break;
                    }
            }
        }
        bw.flush();
    }
}

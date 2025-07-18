import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());
        List<Integer> stack = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];
            switch(cmd){
                case "push":
                    int a = Integer.parseInt(input[1]);
                    stack.add(a);
                    break;
                case "pop":
                    if(stack.isEmpty()){
                        bw.write("-1\n");
                        break;
                    }else{
                        bw.write(stack.get(stack.size()-1) + "\n");
                        stack.remove(stack.size()-1);
                        break;
                    }
                case "size":
                    bw.write(stack.size()+ "\n");
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        bw.write("1\n");
                        break;
                    }
                    else{
                        bw.write("0\n");
                        break;
                    }
                case "top":
                    if(stack.isEmpty()){
                        bw.write("-1\n");
                        break;
                    }
                    else{
                        bw.write(stack.get(stack.size()-1) + "\n");
                        break;
                    }
            }
        }
        bw.flush();
        bw.close();
    }
}

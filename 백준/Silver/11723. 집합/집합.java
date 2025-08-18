
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] index = new int[20];
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int val = 0;
            if(cmd.equals("add") || cmd.equals("remove") || cmd.equals("check") || cmd.equals("toggle")){
                val = Integer.parseInt(st.nextToken()) - 1;
            }

            switch(cmd){
                case "add" :
                    add(val, index);
                    break;
                case "remove" :
                    remove(val, index);
                    break;
                case "check" :
                    check(val, index);
                    break;
                case "toggle" :
                    toggle(val, index);
                    break;
                case "all" :
                    all(index);
                    break;
                case "empty" :
                    empty(index);
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static void add(int a, int[] index){
        index[a] = 1;
    }

    public static void remove(int a, int[] index){
        index[a] = 0;
    }

    public static void check(int a, int[] index){
        sb.append(index[a]).append("\n");
    }

    public static void toggle(int a, int[] index){
        if(index[a] == 1){
            index[a] = 0;
        }
        else if(index[a] == 0){
            index[a] = 1;
        }
    }

    public static void all(int[] index){
        for(int i = 0; i<index.length; i++){
            index[i] = 1;
        }
    }

    public static void empty(int[] index){
        for(int i = 0; i<index.length; i++){
            index[i] = 0;
        }
    }
}

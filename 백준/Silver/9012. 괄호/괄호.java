
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());
        char[] chars;
        for(int i = 0; i<k; i++){
            int tmp = 0;
            boolean flag = true;
            chars = br.readLine().toCharArray();
            for(int j = 0; j<chars.length; j++){
                if(chars[j] == '('){
                    tmp++;
                }
                else if(chars[j] == ')'){
                    tmp--;
                }
                if(tmp < 0){
                    flag = false;
                    break;
                }
            }
            if(tmp == 0){
                bw.write("YES\n");
            }
            else if(flag == false){
                bw.write("NO\n");
            }
            else{
                bw.write("NO\n");
            }
        }
        bw.flush();
        }
    }


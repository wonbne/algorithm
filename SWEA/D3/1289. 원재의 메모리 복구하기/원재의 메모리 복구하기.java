import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k = 1; k<=t; k++){
            String input = sc.next();
            int count = 0;
            boolean is = false;
            for(int i = 0; i<input.length(); i++){
                if(input.charAt(i) -'0' == 1){
                    if(!is){
                        is = true;
                        count++;
                    }
                } else{
                    if(is){
                        count++;
                        is = false;
                    } 
                }
            }
            System.out.println("#" + k + " "+ count);
        }
    }
    
}
import java.io.*;
class Solution {
    public String solution(String[] arr) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String answer = "";
        for(int i = 0; i<arr.length; i++){
            answer += arr[i];
        }
        
        return answer;
    }
}
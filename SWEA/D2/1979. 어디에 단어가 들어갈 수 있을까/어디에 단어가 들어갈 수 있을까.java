import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){

            int n = sc.nextInt();
            int k = sc.nextInt();
            int cnt = 0;

            int arr[][] = new int[n][n];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            // 가로
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){

                    if(arr[i][j] == 1){

                        boolean check = true;

                        // 현재 위치부터 K칸 확인
                        for(int q = 0; q < k; q++){

                            if(j + q >= n || arr[i][j + q] == 0){
                                check = false;
                                break;
                            }
                        }

                        // K칸 앞뒤가 막혀있는지 확인
                        if(check){
                            if(j > 0 && arr[i][j - 1] == 1){
                                check = false;
                            }

                            if(j + k < n && arr[i][j + k] == 1){
                                check = false;
                            }
                        }

                        if(check){
                            cnt++;
                        }
                    }
                }
            }

            // 세로
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){

                    if(arr[i][j] == 1){

                        boolean check = true;

                        // 현재 위치부터 K칸 확인
                        for(int q = 0; q < k; q++){

                            if(i + q >= n || arr[i + q][j] == 0){
                                check = false;
                                break;
                            }
                        }

                        // K칸 앞뒤가 막혀있는지 확인
                        if(check){
                            if(i > 0 && arr[i - 1][j] == 1){
                                check = false;
                            }

                            if(i + k < n && arr[i + k][j] == 1){
                                check = false;
                            }
                        }

                        if(check){
                            cnt++;
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + cnt);
        }
    }
}
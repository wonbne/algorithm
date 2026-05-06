import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[4][4];

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        char c = br.readLine().trim().charAt(0);
        move(c);
        combine(c);
        move(c);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void combine(char dir) {
        if (dir == 'L') {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (arr[i][j] == 0) continue;
                    if (arr[i][j] == arr[i][j + 1]) {
                        arr[i][j] *= 2;
                        arr[i][j + 1] = 0;
                    }
                }
            }
        } else if (dir == 'R') {
            for (int i = 0; i < 4; i++) {
                for (int j = 3; j >= 1; j--) {
                    if (arr[i][j] == 0) continue;
                    if (arr[i][j] == arr[i][j - 1]) {
                        arr[i][j] *= 2;
                        arr[i][j - 1] = 0;
                    }
                }
            }
        } else if (dir == 'U') {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (arr[j][i] == 0) continue;
                    if (arr[j][i] == arr[j + 1][i]) {
                        arr[j][i] *= 2;
                        arr[j + 1][i] = 0;
                    }
                }
            }
        } else if (dir == 'D') {
            for (int i = 0; i < 4; i++) {
                for (int j = 3; j >= 1; j--) {
                    if (arr[j][i] == 0) continue;
                    if (arr[j][i] == arr[j - 1][i]) {
                        arr[j][i] *= 2;
                        arr[j - 1][i] = 0;
                    }
                }
            }
        }
    }


    public static void move(char dir) {

        if (dir == 'L') {
            for (int i = 0; i < 4; i++) {
                int idx = 0;
                for (int j = 0; j < 4; j++) {
                    if (arr[i][j] != 0) {
                        arr[i][idx] = arr[i][j];
                        idx++;
                    }
                }
                for (int j = idx; j < 4; j++) {
                    arr[i][j] = 0;
                }

            }

        } else if (dir == 'R') {

            for (int i = 0; i < 4; i++) {
                int idx = 3;
                for (int j = 3; j >= 0; j--) {
                    if (arr[i][j] != 0) {
                        arr[i][idx] = arr[i][j];
                        idx--;
                    }
                }
                for (int j = 0; j <= idx; j++) {
                    arr[i][j] = 0;
                }

            }

        } else if (dir == 'U') {
            for (int i = 0; i < 4; i++) {
                int idx = 0;
                for (int j = 0; j < 4; j++) {
                    if (arr[j][i] != 0) {
                        arr[idx][i] = arr[j][i];
                        idx++;
                    }
                }
                for (int j = idx; j < 4; j++) {
                    arr[j][i] = 0;
                }
            }


        } else if (dir == 'D') {
            for (int i = 0; i < 4; i++) {
                int idx = 3;
                for (int j = 3; j >= 0; j--) {
                    if (arr[j][i] != 0) {
                        arr[idx][i] = arr[j][i];
                        idx--;
                    }
                }
                for (int j = 0; j <= idx; j++) {
                    arr[j][i] = 0;
                }
            }

        }
    }


}
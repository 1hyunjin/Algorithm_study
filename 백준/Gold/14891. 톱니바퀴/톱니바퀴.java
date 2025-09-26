import java.util.*;
import java.io.*;

public class Main {
    static int[][] wheel;
    static boolean[] isRotate;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheel = new int[5][8];
        for (int i = 1; i <= 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = s.charAt(j)-'0';
            }
        }
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            isRotate = new boolean[5];
            check();
            rotate(num, dir);
        }
        int sum = 0;
        if(wheel[1][0] == 1 ){
            sum+=1;
        }
        if (wheel[2][0] == 1) {
            sum+=2;
        }
        if (wheel[3][0] == 1) {
            sum+=4;
        }
        if (wheel[4][0] == 1) {
            sum+=8;
        }
        System.out.println(sum);
    }
    static List<Integer> list;
    public static void check() {
        for (int i = 1; i <= 3; i++) {
            if (wheel[i][2] == wheel[i + 1][6]) {
                list.add(1);
            }
            else{
                list.add(-1);
            }
        }
    }

    public static void rotate(int num, int dir) {
        if (num == 1 && !isRotate[num]) {
            if (dir == 1) {
                right(1);
                isRotate[num] = true;
            }
            else{
                left(1);
                isRotate[num] = true;
            }
            int two = list.get(0);
            if (two == -1) {
                if (dir == 1) {
                    rotate(2, -1);
                }
                else{
                    rotate(2, 1);
                }
            }
        } else if (num == 2 && !isRotate[num]) {
            if (dir == 1) {
                right(2);
                isRotate[num] = true;
            }
            else{
                left(2);
                isRotate[num] = true;
            }
            int one = list.get(0);
            int three = list.get(1);
            if (one == -1) {
                if (dir == 1) {
                    rotate(1, -1);
                } else {
                    rotate(1, 1);
                }
            }
            if (three == -1) {
                if (dir == 1) {
                    rotate(3, -1);
                } else {
                    rotate(3, 1);
                }
            }
        } else if (num == 3 && !isRotate[num]) {
            if (dir == 1) {
                right(3);
                isRotate[num] = true;
            }
            else{
                left(3);
                isRotate[num] = true;
            }
            int two = list.get(1);
            int four = list.get(2);
            if (two == -1) {
                if (dir == 1) {
                    rotate(2, -1);
                } else {
                    rotate(2, 1);
                }
            }
            if (four == -1) {
                if (dir == 1) {
                    rotate(4, -1);
                } else {
                    rotate(4, 1);
                }
            }
        } else if(num == 4 && !isRotate[num]){
            if (dir == 1) {
                right(4);
                isRotate[num] = true;
            }
            else{
                left(4);
                isRotate[num] = true;
            }
            int three = list.get(2);
            if (three == -1) {
                if (dir == 1) {
                    rotate(3, -1);
                }
                else{
                    rotate(3, 1);
                }
            }
        }
    }
    public static void right(int num) {
        int last = wheel[num][7];
        for (int i = 7; i >= 1; i--) {
            wheel[num][i] = wheel[num][i-1];
        }
        wheel[num][0] = last;
    }

    public static void left(int num) {
        int first = wheel[num][0];
        for (int i = 0; i < 7; i++) {
            wheel[num][i] = wheel[num][i+1];
        }
        wheel[num][7] = first;
    }
}
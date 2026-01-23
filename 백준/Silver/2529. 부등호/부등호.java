import java.io.*;
import java.util.*;

class Main {
    static int[] arr;
    static int k, S;
    static boolean[] isSelected;
    static int[] result;
    static char[] op;
    static List<String> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new int[10];
        op = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            op[i] = st.nextToken().charAt(0);
        }
        S = k+1;
        result = new int[k+1];
        isSelected = new boolean[10];
        list = new ArrayList<>();
        back(0, 0);
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }

    public static void back(int idx, int cnt) {
        if(cnt == S){
            int a = result[0];
            StringBuilder sb = new StringBuilder();
            sb.append(a);
            boolean isMatch = true;
            for (int j = 1; j < S; j++) {
                int b = result[j];
                char c = op[j-1];
                if (c == '>') {
                    if (a > b) {
                        a = b;
                        sb.append(b);
                    }
                    else{
                        isMatch = false;
                        break;
                    }
                }
                else{
                    if (a < b) {
                        a = b;
                        sb.append(b);
                    }
                    else{
                        isMatch = false;
                        break;
                    }
                }
            }
            if (isMatch) {
                list.add(sb.toString());
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                result[cnt] = i;
                back(idx+1, cnt+1);
                isSelected[i] = false;
            }
        }
    }
}
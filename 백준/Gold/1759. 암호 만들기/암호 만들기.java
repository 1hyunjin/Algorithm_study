import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] alpha;
    static char[] result;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpha = new char[C];
        result = new char[L];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alpha);

        comb(0,0);	//조합 : 6개 중 4개 뽑는 경우
    }

    public static void comb(int idx, int cnt) {

        if(cnt == L) {
            int moem = 0;
            int jaem = 0;
            for(int i = 0; i < result.length; i++) {
                if(result[i] == 'a' || result[i] == 'e' || result[i] == 'i'
                        || result[i] == 'o'|| result[i] == 'u') {
                    moem++;
                } else {
                    jaem++;
                }
            }
            if(moem >= 1 && jaem >= 2) {
                for (int j = 0; j < result.length; j++) {
                    System.out.print(result[j]);
                }
                System.out.println();
            }

            return;
        }

        if(idx == alpha.length) {
            return;
        }

        result[cnt] = alpha[idx];
        comb(idx + 1, cnt + 1);
        comb(idx+1, cnt);

    }
}
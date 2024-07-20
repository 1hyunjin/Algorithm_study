import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] lc;
    static int[] rc;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        lc = new int[N+1];
        rc = new int[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            char c, l, r;
            c = st.nextToken().charAt(0);
            l = st.nextToken().charAt(0);
            r = st.nextToken().charAt(0);
            if (l != '.') {
                lc[c-'A'+1] = l-'A'+1;
            }
            if (r != '.') {
                rc[c-'A'+1] = r-'A'+1;
            }
        }
        preorder(1);
        sb.append("\n");
        inorder(1);
        sb.append("\n");
        postorder(1);
        System.out.println(sb.toString());
    }

    public static void preorder(int cur) {
        sb.append((char) (cur+'A'-1));
        if (lc[cur] != 0) {
            preorder(lc[cur]);
        }
        if(rc[cur] != 0) {
            preorder(rc[cur]);
        }
    }

    public static void inorder(int cur) {
        if(lc[cur] != 0) {
            inorder(lc[cur]);
        }
        sb.append((char) (cur+'A'-1));
        if(rc[cur] != 0) {
            inorder(rc[cur]);
        }
    }

    public static void postorder(int cur) {
        if (lc[cur] != 0) {
            postorder(lc[cur]);
        }
        if(rc[cur] != 0) {
            postorder(rc[cur]);
        }
        sb.append((char) (cur+'A'-1));
    }
}
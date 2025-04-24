import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        int needs;
        
        if (game == 'Y') {
            needs = 1;
        } else if (game == 'F') {
            needs = 2;
        }
        else {
            needs = 3;
        }
        System.out.println(set.size()/needs);
    }
}
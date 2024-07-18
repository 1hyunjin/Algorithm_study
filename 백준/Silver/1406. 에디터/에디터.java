import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());

        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        ListIterator<Character>  iter = list.listIterator();

        // 처음 커서는 문장의 맨 뒤에 있어야하기 때문에 커서를 맨 뒤로 이동시켜줌.
        while(iter.hasNext()) {
            iter.next();
        }

        for(int tc = 0; tc < TC; tc++) {
           String command = br.readLine();
            char c = command.charAt(0);
            switch (c) {
                case 'L' :
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                    break;
                case 'D':
                    if (iter.hasNext()) {
                        iter.next();
                    }
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char t = command.charAt(2);
                    iter.add(t);
                    break;
                default:
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
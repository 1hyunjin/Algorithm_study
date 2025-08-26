import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            boolean isPut = false; // 지정 유무?
            boolean isPossible = true;
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                String s = arr[j];
                char first = Character.toUpperCase(s.charAt(0));
                if (!isPut && !set.contains(first)) { // 단축키 지정 안했고, 첫글자가 단축키로 지정되지 않은 경우
                    set.add(first);
                    isPut = true; // 단축키로 지정했어.
                    isPossible = true;

                    if (tmp.length()>0) {
                        sb.append(tmp).append(" ");
                        tmp.setLength(0);
                    }
                    sb.append("[").append(s.charAt(0)).append("]").append(s, 1, s.length());
                    if(j < arr.length-1) {
                        sb.append(" ");
                    }
                } else if (!isPut && set.contains(first)) { // 첫 글자가 이미 단축키로 지정되있는 경우
                    isPossible = false; //
                    if(tmp.length()>0) tmp.append(" ");
                    tmp.append(s);

                } else if (isPut) { // 이미 전의 단어에서 단축키로 지정된 경우잖아.
                    sb.append(s);
                    if(j < arr.length-1) sb.append(" ");
                }
            }

            // 모든 단어의 첫 글자가 이미 지정되어 있다면 왼쪽부터 알파벳 확인하기.
            if (!isPossible) {
                StringBuilder t = new StringBuilder();
                boolean ok = false;
                for (int k = 0; k < arr.length; k++) {
                    String str = arr[k];
                    for (int l = 0; l < str.length(); l++) {
                        if (!ok && !set.contains(Character.toUpperCase(str.charAt(l)))) {
                            t.append("[").append(str.charAt(l)).append("]");
                            set.add(Character.toUpperCase(str.charAt(l)));
                            ok = true;

                        } else {
                            t.append(str.charAt(l));
                        }
                    }
                    if(k < arr.length-1) t.append(" ");
                }
                sb.append(t);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
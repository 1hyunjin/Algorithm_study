import java.util.*;
import java.io.*;
public class Main {
    static Map<Character, Integer> map;
    static StringBuilder answer;
    static char[][] arr;
    public static void main(String[] args) throws Exception{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine(); // 암호화할 메시지
        String K = br.readLine(); // 키 

        arr = new char[5][5];
        int[] alpha = new int[26];
        // System.out.println('J'-'A'); // J -> 인덱스 9
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < K.length(); i++){
            char c = K.charAt(i);
            if(alpha[c-'A'] == 0){
                sb.append(c);
                alpha[c-'A']++;
            }
        }
        for(int i = 0; i < 26; i++){
            if(alpha[i] == 0 && i != 9){
                sb.append((char)(i+'A'));
            }
        }
        String tmp = sb.toString();
        map = new HashMap<>();
        for(int i = 0; i < tmp.length(); i++){
            map.put(tmp.charAt(i), i);
        }

        int idx = 0;
        for(int i = 0; i < tmp.length(); i+=5){
            String t = tmp.substring(i, i+5);
            for(int j = 0; j < 5; j++){
                arr[idx][j] = t.charAt(j);
            }
            idx++;
        }

        answer = new StringBuilder();
        for(int i =0; i < S.length(); i++){
            String pair = "";
            char cur = S.charAt(i);
            if(i+1 == S.length()){
                cipher(cur, 'X');
                break;
            }
            char next = S.charAt(i+1);

            if(cur != next){
                cipher(cur, next);
                i++;
            }
            else{
                if(cur == 'X'){
                    cipher(cur, 'Q');
                }
                else{
                    cipher(cur, 'X');
                }
            }
        }
        System.out.println(answer.toString());
    }
    public static void cipher(char left, char right){
        int lv = map.get(left);
        int rv = map.get(right);

        int lx = lv/5;
        int ly = lv%5;
        int rx = rv/5;
        int ry = rv%5;

        if(lx == rx){   // 같은 행에 존재한다면 오른쪽으로 한 칸 이동한 칸에 적힌 글자로 암호화
            char a = arr[lx][(ly+1)%5];
            char b = arr[rx][(ry+1)%5];
            answer.append(a).append(b);
        }
        else if(ly == ry){  // 같은 열에 존재한다면 아래쪽으로 한 칸 이동한 칸에 적힌 글자로 암호화
            char a = arr[(lx+1)%5][ly];
            char b = arr[(rx+1)%5][ry];
            answer.append(a).append(b);
        }
        else{
            char a = arr[lx][ry];
            char b = arr[rx][ly];
            answer.append(a).append(b);
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String PPAP = "PPAP";
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++){
            stack.add(str.charAt(i));

            if(stack.size() >= 4) {
                String tmp = "";
                for (int j = 0; j < 4; j++) {
                    tmp = stack.pop() + tmp;
                }
                if (tmp.equals(PPAP)) {
                    stack.add('P');
                } else {
                    for (int j = 0; j < 4; j++) {
                        stack.add(tmp.charAt(j));
                    }
                }
            }
        }
        if(stack.size()==1 && stack.peek()=='P'){
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
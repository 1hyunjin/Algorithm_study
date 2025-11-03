import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<Character, String> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();
        for (int i = M; i <= N; i++) {
            String s = "";
            s+=i;
            StringBuilder sb = new StringBuilder();
            String[] arr = s.split("");
            for (int j = 0; j < s.length(); j++) {
                sb.append(numToString(arr[j])).append(" ");
            }
            list.add(sb.toString());
        }
        Collections.sort(list);
        List<Integer> number = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            String[] arr = s.split(" ");
            StringBuilder sb= new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                sb.append(stringToNum(arr[j]));
            }
            number.add(Integer.parseInt(sb.toString()));
        }
        int cnt = 1;
        for (int i = 0; i < number.size(); i++) {
            if (cnt % 10 == 0) {
                System.out.print(number.get(i));
                System.out.println();
            }
            else{
                System.out.print(number.get(i) + " ");
            }
            cnt++;
        }
    }
    public static String numToString(String s){
        switch(s){
            case "0" : return "zero";
            case "1" : return "one";
            case "2" : return "two";
            case "3" : return "three";
            case "4" : return "four";
            case "5" : return "five";
            case "6" : return "six";
            case "7" : return "seven";
            case "8" : return "eight";
            case "9" : return "nine";
            default : return "";
        }
    }

    public static String stringToNum(String s) {
        switch(s){
            case "zero" : return "0";
            case "one" : return "1";
            case "two" : return "2";
            case "three" : return "3";
            case "four" : return "4";
            case "five" : return "5";
            case "six" : return "6";
            case "seven" : return "7";
            case "eight" : return "8";
            case "nine" : return "9";
            default : return "";
        }
    }
}
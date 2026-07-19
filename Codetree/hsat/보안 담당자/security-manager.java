import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        // Please write your code here.
        if(s.length() % 2 != 0){
            System.out.println("No");
            return;
        }
        int bal = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '(' || c == '?'){
                bal++;
            }
            else{
                bal--;
            }
            if(bal < 0){
                System.out.println("No");
                return;
            }   
        }
        
        bal = 0;
        for(int i = s.length()-1; i >= 0;  i--){
            char c = s.charAt(i);

            if(c == ')' || c == '?'){
                bal++;
            }
            else{
                bal--;
            }
            if(bal < 0){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
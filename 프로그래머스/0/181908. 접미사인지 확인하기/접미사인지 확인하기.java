import java.io.*;
import java.util.*;
class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        int n = my_string.length();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < my_string.length(); i++){
            set.add(my_string.substring(i, n));
        }
        if(set.contains(is_suffix)){
            return 1;
        }
        else{
            return 0;
        }
    }
}
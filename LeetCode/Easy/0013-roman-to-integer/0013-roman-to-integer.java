class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
            'I', 1,
            'V', 5, 
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'I'){
                if(i < s.length()-1){
                    if(s.charAt(i+1) == 'V'){
                    sum += 4;
                    i+=1;
                    }
                    else if(s.charAt(i+1) == 'X'){
                        sum += 9;
                        i+=1;
                    }
                    else{
                        sum += 1;
                    }
                }
                else{
                    sum += 1;
                }
            }
            else if(c == 'V'){
                sum += 5;
            }
            else if(c == 'X'){
                if(i < s.length()-1){
                    if(s.charAt(i+1) == 'L'){
                    sum += 40;
                    i+=1;
                    }
                    else if(s.charAt(i+1) == 'C'){
                        sum += 90;
                        i+=1;
                    }
                    else{
                        sum += 10;
                    }
                }
                else{
                    sum += 10;
                }
            }
            else if(c == 'L'){
                sum += 50;
            }
            else if(c == 'C'){
                if(i < s.length()-1){
                    if(s.charAt(i+1) == 'D'){
                    sum += 400;
                    i+=1;
                    }
                    else if(s.charAt(i+1) == 'M'){
                        sum += 900;
                        i+=1;
                    }
                    else{
                        sum += 100;
                    }
                }
                else{
                    sum += 100;
                }
            }
            else if(c == 'D'){
                sum += 500;
            }
            else {
                sum += 1000;
            }
        }
        return sum;
    }
}
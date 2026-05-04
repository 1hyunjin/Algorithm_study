class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                if(c == ')' || c == '}' || c== ']'){
                    return false;
                }
            }
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else if(c == ')'){
                if(stack.peek() == '('){
                    stack.pop();
                }
                else {
                    return false;
                }
            }
            else if(c == '}'){
                if(stack.peek() == '{'){
                    stack.pop();
                }
                else {
                    return false;
                }
            }
            else if(c == ']'){
                if(stack.peek() == '['){
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
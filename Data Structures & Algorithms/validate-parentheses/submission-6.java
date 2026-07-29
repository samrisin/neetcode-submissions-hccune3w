class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c==')'){
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                    continue;
                }
                return false;
            }else if(c=='}'){
                if(!stack.isEmpty() && stack.peek()=='{'){
                    stack.pop();
                    continue;
                }
                return false;
            }else   if(c==']'){
                if(!stack.isEmpty() && stack.peek()=='['){
                    stack.pop();
                    continue;
                }
                return false;
            }
        stack.push(c);
        }
    return stack.isEmpty();
    }
}

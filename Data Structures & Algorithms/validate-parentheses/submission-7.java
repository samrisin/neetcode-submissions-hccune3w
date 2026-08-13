class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> pairs = new HashMap<>();
        pairs.put(')','(');
        pairs.put(']','[');
        pairs.put('}','{');
        Stack<Character> stack = new Stack<>();

        for(var c:s.toCharArray()){
            if(c==')' || c=='}' || c==']' ){
                if(stack.isEmpty() || stack.peek()!=pairs.get(c)) return false;
                stack.pop();
            }else{
                stack.push(c);
            }
            
        }
        return stack.isEmpty();

    }


}

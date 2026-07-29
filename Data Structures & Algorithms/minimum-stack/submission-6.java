class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(!minStack.isEmpty() && minStack.peek()>=val){
            minStack.push(val);
        }
        if(minStack.isEmpty()) minStack.push(val);
    
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            int top = stack.pop();
            if(minStack.peek()==top){
                minStack.pop();
            }

        }
    
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

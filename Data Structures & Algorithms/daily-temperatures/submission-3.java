class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       int[] res = new int[temperatures.length];

       Stack<Integer> stack = new Stack<Integer>();

       stack.push(0);

       for(int i=1;i<temperatures.length;i++){
        while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
            int ind = stack.pop();
            res[ind] = i-ind;
        };
        stack.push(i);
       }
       return res;
    }
}

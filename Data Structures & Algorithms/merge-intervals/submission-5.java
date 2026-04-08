class Solution {
  
    public int[][] merge(int[][] intervals) {
         Stack<int[]> stack = new Stack<>();
         Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        for(int[] interval:intervals){
            if(stack.isEmpty() || stack.peek()[1]<interval[0]){
                stack.push(interval);
            }else{
                int[] last = stack.pop();

                stack.push(new int[]{last[0],Math.max(interval[1],last[1])});
            }
        }

        int[][] res = new int[stack.size()][2];
        int n = stack.size();
        while(!stack.isEmpty()){
            res[--n] = stack.pop();
        }

        return res;
    }
}

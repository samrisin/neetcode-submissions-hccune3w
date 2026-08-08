class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sumOfSquares=0;
        while(n!=1){
           sumOfSquares = getSumOfSquares(n);
           if(set.contains(sumOfSquares)) return false;
           set.add(sumOfSquares);
           n = sumOfSquares;
        }
    return true;
    }

    public int getSumOfSquares(int n){
        int sum = 0;
        while(n!=0){
            int d  = n%10;
            sum+=d*d;
            n/=10;
        }
        return sum;
    }
}

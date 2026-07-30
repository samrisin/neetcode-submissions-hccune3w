class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxbananas = Arrays.stream(piles).max().getAsInt();

        int left=1;
        int right = maxbananas;
        int ans = maxbananas;
        while(left<=right){
            int mid = left+ (right-left)/2;
            if(canEat(mid,piles,h)){
          
                if(ans>mid){
                    ans = mid;
                }
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
    return ans;
    }

    public boolean canEat(int val,int[]piles, int totalHours){
        int h = 0;

        for(int pile:piles){
       h += (int) Math.ceil((double) pile / val);
            if(h>totalHours) return false;
        }
    return true;
    }
    
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];

     Deque<Integer> q = new LinkedList<>();
        int l=0;
        for(int r=0;r<n;r++){
            while(!q.isEmpty() && nums[q.getLast()]<nums[r]){
                q.removeLast();
            }
            q.addLast(r);
            if(q.getFirst()<l){
                q.removeFirst();
            }

            if((r+1)>=k){
                res[l]=nums[q.getFirst()];
                l++;
            }
        }
    return res;
    }
}

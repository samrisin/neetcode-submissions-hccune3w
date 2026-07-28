class Solution {
    public int trap(int[] heights) {
        int l = 0;
        int r = heights.length-1;
        int maxL = heights[l];
        int maxR = heights[r];
        int res=0;
        while(l<r){
            if(heights[l]<heights[r]){
                l++;
                maxL = Math.max(maxL,heights[l]);
                res+= maxL-heights[l];

            }else{
                r--;
                maxR = Math.max(maxR,heights[r]);
                res+=maxR-heights[r];
            }
        }
    return res;
    }
}

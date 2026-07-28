class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;

        Set<Character> set = new HashSet<>();
        int maxL = 0;

        while(right<s.length()){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxL= Math.max(maxL,right-left+1);
            right++;

        }
    return maxL;
    }
}

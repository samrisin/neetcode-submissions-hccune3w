class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> need = new HashMap<>();

        for(char ch:s1.toCharArray()){
            need.put(ch,need.getOrDefault(ch,0)+1);
        }

        int r=0;
        int k = s1.length();
        int formed=0;
        int required = need.size();
     Map<Character,Integer> have = new HashMap<>();
        while(r<s2.length()){
            char c = s2.charAt(r);
            have.put(c,have.getOrDefault(c,0)+1);

            if (need.containsKey(c) &&
                have.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

               if (r >= k) {

                char curr = s2.charAt(r - k);

                // if it was valid before removal
                if (need.containsKey(curr) &&
                    have.get(curr) == need.get(curr)) {
                    formed--;
                }

                have.put(curr, have.get(curr) - 1);

                if (have.get(curr) == 0) {
                    have.remove(curr);
                }
            }

            if(formed==required) return true;
            r++;
        }
    return false;
    }
}

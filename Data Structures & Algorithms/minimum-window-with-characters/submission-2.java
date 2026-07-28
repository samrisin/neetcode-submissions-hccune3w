class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length() || t.equals("") || s.equals("")) return "";
        HashMap<Character,Integer> need = new HashMap<>();

        for(char c:t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }

        int required = need.size();
        int formed=0;
        int left=0;
        int minLen=s.length();
        int[] arr = {-1,-1};
        Map<Character,Integer> have = new HashMap<>();
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            have.put(c,have.getOrDefault(c,0)+1);

            if(need.containsKey(c)&& need.get(c)==have.get(c)){
                formed++;
            }

            while(formed==required){
                if(minLen>=(r-left+1)){
                    minLen = r-left+1;
                    arr[0]=left;
                    arr[1]=r;
                }
            
                char leftChar = s.charAt(left);
                have.put(leftChar,have.get(leftChar)-1);
               
                if(need.containsKey(leftChar) && have.get(leftChar)==need.get(leftChar)-1){
                    formed--;
                }
                 if(have.get(leftChar)==0){
                    have.remove(leftChar);
                }
                left++;

            }

        }
    return arr[0]!=-1 ?s.substring(arr[0],arr[1]+1):"";
    }
}

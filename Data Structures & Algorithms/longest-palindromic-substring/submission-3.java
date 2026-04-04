class Solution {
     String result;
     int maxLen;
    public String longestPalindrome(String s) {
       if(s.equals("") || s==null) return "";
        for(int i=0;i<s.length();i++){
            expandAroundCenter(i,i,s);
            expandAroundCenter(i,i+1,s);

        }
        return result;
    }

       public void expandAroundCenter(int l,int r,String s){
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
             
                if(((r-l)+1)>maxLen){
                    maxLen = r-l+1;
                    result = s.substring(l,r+1);
                }
                l--;
                r++;
            }
        }
    }




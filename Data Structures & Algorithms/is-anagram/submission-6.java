class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] sChar = new char[26];
        char[] tChar = new char[26];
   

        for(int i=0;i<s.length();i++){
            sChar[s.charAt(i)-'a']++;
            tChar[t.charAt(i)-'a']++;
        }

        return Arrays.equals(sChar,tChar);
    }
}

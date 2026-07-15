class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack( s,0,new ArrayList<>() );
        return result;
    }


    public void backtrack(String s, int i, List<String> curr){
        if(i==s.length()){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int j=i;j<s.length();j++){
            if(isPalindrome(i,j,s)){
                curr.add(s.substring(i,j+1));
                backtrack(s,j+1,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    private boolean isPalindrome(int i, int j, String s){
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;

            }else{
                return false;
            }
        }
    return true;
    }
}

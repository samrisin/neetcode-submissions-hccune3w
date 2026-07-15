class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        
        generate(0,0,n,new StringBuilder());
        return result;
    }

    public void generate(int open, int close, int n, StringBuilder curr){
        if(open==close && open==n){
            result.add(curr.toString());
            return;
        }

        if(open<n){
            curr.append("(");
            generate(open+1,close,n,curr);
            curr.setLength(curr.length()-1);
        }

        if(close<open){
            curr.append(")");
            generate(open,close+1,n,curr);
            curr.setLength(curr.length()-1);
        }
}
}

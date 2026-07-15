class Solution {
    int n;
    int m;
    private Set<Pair<Integer, Integer>> path = new HashSet<>();
    public boolean exist(char[][] board, String word) {
         n = board.length;
         m = board[0].length;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(backtrack(board,word,i,j,0)) return true;
                }
            }
        }
    return false;
    }


    public boolean backtrack(char[][] board, String word, int i, int j, int ind){
        if(ind==word.length()) return true;
        if(i>=n || j>=m ||j<0 || i<0 || board[i][j]!=word.charAt(ind) || path.contains(new Pair<>(i,j))) return false;

        path.add(new Pair<>(i,j));
        if( backtrack(board,word,i+1,j, ind+1) || backtrack(board,word,i,j+1, ind+1) ||  backtrack(board,word,i,j-1, ind+1)
        ||  backtrack(board,word,i-1,j, ind+1 )) return true;
        path.remove(new Pair<>(i,j));

        return false;
    }
}

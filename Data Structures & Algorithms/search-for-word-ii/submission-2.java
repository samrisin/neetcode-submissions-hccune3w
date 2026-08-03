class Solution {
    List<String> result = new ArrayList<>();
    int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
    int n;
    int m;
    public List<String> findWords(char[][] board, String[] words) {
         n = board.length;
         m = board[0].length;
        Trie root = new Trie();
        int k = 0;
        for(var word:words){
            Trie curr = root;
            curr.refs++;
            for(char c:word.toCharArray()){
                int ind = c-'a';
                if(curr.children[ind]==null){
                    curr.children[ind] = new Trie();
                }
                curr = curr.children[ind];
                curr.refs++;
            }
            curr.idx = k++;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                root.refs-=dfs(i,j,root,board,words);
            }
        }
    
    return result;
    }

    private int dfs(int r, int c,Trie node,char[][]board,String[] words){
    
        if(r<0 || r>=n || c<0 ||c>=m || board[r][c]=='*' || node.children[board[r][c]-'a']==null){
            return 0;
        }

        char temp = board[r][c];
        board[r][c] = '*';
        Trie prev = node;
        node = node.children[temp-'a'];
        int found = 0;
        if(node.idx!=-1){
            result.add(words[node.idx]);
            node.idx=-1;
            found++;
        }

        found+=dfs(r+1,c,node,board,words);
        found+=dfs(r,c+1,node,board,words);
        found+=dfs(r-1,c,node,board,words);
        found+=dfs(r,c-1,node,board,words);

        board[r][c] = temp;
        node.refs-=found;
        if(node.refs==0){
            prev.children[temp-'a']=null;
        }
    return found;
    }
}

class Trie{
    Trie[] children;
    int idx = -1;
    int refs = 0;
    public Trie(){
        children = new Trie[26];
    }
}

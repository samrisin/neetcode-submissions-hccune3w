class PrefixTree {
    Trie root;
    public PrefixTree() {
         root = new Trie();
    }

    public void insert(String word) {
        Trie curr = root;
        for(char c:word.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new Trie();
            }
            curr = curr.children[c-'a'];
        }
        curr.end = true;

    }

    public boolean search(String word) {
     Trie curr = root;
        for(char c:word.toCharArray()){
            if(curr.children[c-'a']==null){
                return false;
            }
         curr = curr.children[c-'a'];
    }
    return curr.end;
    }

    public boolean startsWith(String prefix) {
        Trie curr = root;
        for(char c:prefix.toCharArray()){
            if(curr.children[c-'a']==null){
                return false;
            }
         curr = curr.children[c-'a'];
    }
    return true;
    }
}

class Trie{
    Trie[] children = new Trie[26];
    boolean end;
    public Trie(){
        end = false;
    }
}

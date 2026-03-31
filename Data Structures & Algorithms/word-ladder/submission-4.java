class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        int transform = 1;
        if(!words.contains(endWord) || endWord.length()!=beginWord.length() ) return 0;
        Queue<String> q = new ArrayDeque();
        q.add(beginWord);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                String word = q.poll();
                char[] wordArr = word.toCharArray();
                for(int j=0;j<word.length();j++){
                    char c = word.charAt(j);

                    for(char k ='a';k<='z';k++ ){
                        if(k==c) continue;
                        wordArr[j] = k;
                        String newWord = new String(wordArr);
                        if(words.contains(newWord)){
                            if(newWord.equals(endWord)) return transform+1;
                            q.add(newWord);
                            words.remove(newWord);
                        }
                    }
                    wordArr[j] = c;
                }
            }
            transform++;
            
        }
        return 0;
    }
}

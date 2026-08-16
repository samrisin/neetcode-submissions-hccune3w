class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];
        for (int j = 0; j <= word2.length(); j++) {
            dp[word1.length()][j] = word2.length() - j;
        }
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][word2.length()] = word1.length() - i;
        }
        for(int i=m-1;i>=0;i--){
        for(int j=n-1;j>=0;j--){
            if(word1.charAt(i)==word2.charAt(j)){
                dp[i][j] = dp[i+1][j+1];
            }else{
                int insert = dp[i][j+1];
                int delete = dp[i+1][j];
                int replace = dp[i+1][j+1];

                dp[i][j] = 1 + Math.min(Math.min(insert,delete),replace);

            }
        }
        }
    return dp[0][0];
    }
}

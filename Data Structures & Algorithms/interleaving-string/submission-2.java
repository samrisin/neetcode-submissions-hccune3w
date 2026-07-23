class Solution {
    int n;
    int m;
        private Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        n= s1.length();
        m = s2.length();
        if(n+m!=s3.length()) return false;
             dp = new Boolean[n+ 1][m+ 1];
       return dfs(0,0,0,s1,s2,s3);
    }


    public boolean dfs(int i, int j,int k,String s1, String s2, String s3){
       if (k == s3.length()) {
            return (i == n) && (j == m);
        }
         if (dp[i][j] != null) {
            return dp[i][j];
        }
         boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = dfs(i + 1, j, k + 1, s1, s2, s3);
        }
        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res = dfs(i, j + 1, k + 1, s1, s2, s3);
        }
        dp[i][j] = res;
    return res;
    }
}

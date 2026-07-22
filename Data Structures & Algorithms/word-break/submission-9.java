class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();

        // dp[i] means s.substring(i) can be segmented.
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                if (dp[j] && words.contains(s.substring(i, j))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
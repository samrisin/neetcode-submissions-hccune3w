class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer[][] memo = new Integer[n][n];

        return dfs(0, n - 1, piles, memo) > 0;
    }

    // Returns the maximum score difference
    // current player can achieve over the other player.
    private int dfs(int i, int j, int[] piles, Integer[][] memo) {
        if (i == j) {
            return piles[i];
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int takeLeft = piles[i] - dfs(i + 1, j, piles, memo);
        int takeRight = piles[j] - dfs(i, j - 1, piles, memo);

        memo[i][j] = Math.max(takeLeft, takeRight);

        return memo[i][j];
    }
}
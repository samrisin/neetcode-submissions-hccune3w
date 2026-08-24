class Solution {
    int m, n;
    int[][] points;
    Long[][] memo;

    long dfs(int r, int c) {
        if (memo[r][c] != null) return memo[r][c];
        if (r == m - 1) return 0;

        long res = 0;
        for (int col = 0; col < n; col++) {
            res = Math.max(res, points[r + 1][col] - Math.abs(col - c) + dfs(r + 1, col));
        }
        return memo[r][c] = res;
    }

    public long maxPoints(int[][] points) {
        this.points = points;
        m = points.length;
        n = points[0].length;
        memo = new Long[m][n];
        long ans = 0;
        for (int c = 0; c < n; c++) {
            ans = Math.max(ans, points[0][c] + dfs(0, c));
        }
        return ans;
    }
}
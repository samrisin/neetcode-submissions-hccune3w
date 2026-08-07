class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        int n = matrix.length;
        int m = matrix[0].length;

        int r = 0, c = 0;
        int k = 0;
        int[] dir = dirs[0];

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n * m; i++) {

            res.add(matrix[r][c]);
            matrix[r][c] = -101;

            if (r + dir[0] < 0 || r + dir[0] >= n ||
                c + dir[1] < 0 || c + dir[1] >= m ||
                matrix[r + dir[0]][c + dir[1]] == -101) {

                k++;
                dir = dirs[k % 4];
            }

            r += dir[0];
            c += dir[1];
        }

        return res;
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Stack<int[]> stack = new Stack<>();

        for (int[] interval : intervals) {
            if (!stack.isEmpty() && stack.peek()[1] >= interval[0]) {
                int[] curr = stack.pop();
                stack.push(new int[]{
                    curr[0],
                    Math.max(curr[1], interval[1])
                });
            } else {
                stack.push(interval);
            }
        }

        int[][] res = new int[stack.size()][2];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}

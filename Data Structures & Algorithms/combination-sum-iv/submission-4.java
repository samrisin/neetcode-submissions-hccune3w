public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        for (int total = 1; total <= target; total++) {
            for (int num : nums) {
                dp.put(total, dp.getOrDefault(total, 0) + dp.getOrDefault(total - num, 0));
            }
        }
        return dp.getOrDefault(target, 0);
    }
}
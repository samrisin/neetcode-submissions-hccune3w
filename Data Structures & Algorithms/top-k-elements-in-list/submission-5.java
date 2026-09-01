class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[n+1];

        for(int i=0;i<n;i++){
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
            freq[i] = new ArrayList<>();
        }
        freq[n] = new ArrayList<>();
        for(var entry:count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }


      int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int val : freq[i]) {
                res[index++] = val;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }

    }


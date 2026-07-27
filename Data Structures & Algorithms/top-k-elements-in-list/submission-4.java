class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->freq.get(b)-freq.get(a));

        for(int num:freq.keySet()){
            pq.add(num);
        }
        int[] result = new int[k];
        k--;
        while(k>=0 ){
            result[k] = pq.poll();
            k--;
        }

        return result;
    }
}

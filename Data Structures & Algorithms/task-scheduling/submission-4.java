class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(var task:tasks){
            freq[task-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int i=0;i<26;i++){
            if(freq[i]>0){
                pq.add(freq[i]);
            }
        }
        int result = 0;
        
      
    
        while(!pq.isEmpty()){
            int cycle = n;
            int taskCount = 0;
            List<Integer> store = new ArrayList<>();
            while(!pq.isEmpty() && cycle-->=0){
                int curr = pq.poll();
                if(curr>1){
                store.add(curr-1);
                }
                taskCount++;

            }
            store.forEach(pq::offer);
            result+=pq.isEmpty()?taskCount:n+1;
        }
    return result;
    }
}

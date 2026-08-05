class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer,Integer> freq = new HashMap<>();

        for(int h:hand){
          freq.put(h,freq.getOrDefault(h,0)+1);

        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(freq.keySet());

        while(!pq.isEmpty()){
            int n = groupSize;
            int first = -1;
            List<Integer> store = new ArrayList<>();
            int size = 0;
            while(!pq.isEmpty() && n-->0){
                if(first==-1){
                    first = pq.poll();
                }else{
                    if(pq.peek()!=first+1) return false;
                    first = pq.poll();
                }
                  if(freq.get(first)>1){
                        store.add(first);
                    }
                    freq.put(first,freq.get(first)-1);
                    if(freq.get(first)==0) freq.remove(first);
                    size++;
                
            }
            if(size!=groupSize) return false;
            store.forEach((pq::offer));

        }
    return true;
    }
}

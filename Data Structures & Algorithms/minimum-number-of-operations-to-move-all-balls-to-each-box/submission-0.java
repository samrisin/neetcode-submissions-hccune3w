class Solution {
    public int[] minOperations(String boxes) {
        Set<Integer> set = new HashSet<>();
        int n = boxes.length();

        for(int i=0;i<n;i++){
                if(boxes.charAt(i)=='1'){
                    set.add(i);
                }
            
        }
        int[] minops = new int[n];
        for(int i=0;i<n;i++){
                for(int j:set){
                   minops[i]+=Math.abs(i-j); 
            }
        }
    return minops;
    }
}
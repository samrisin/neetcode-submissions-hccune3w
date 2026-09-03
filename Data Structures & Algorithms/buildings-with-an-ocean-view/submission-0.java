class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> result = new ArrayList<>();
        result.add(n-1);
        for( int i=n-2;i>=0;i--){
            if(heights[result.get(result.size()-1)]<heights[i]){
                result.add(i);
            }
        }
    Collections.reverse(result);
    return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
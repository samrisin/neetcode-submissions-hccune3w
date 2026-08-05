class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> lastInd = new HashMap<>();
        int i = 0;
        for(char c:s.toCharArray()){
            lastInd.put(c,i++);
        }

        List<Integer> res = new ArrayList<>();
        int size = 0;
        int end = 0;
        for( i=0;i<s.length();i++){
            size++;
            end = Math.max(end,lastInd.get(s.charAt(i)));
            if(i==end){
                res.add(size);
                size=0;
            }
        }
    return res;
    }
}

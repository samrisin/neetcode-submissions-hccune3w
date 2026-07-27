class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagrams = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char[] cArr = strs[i].toCharArray();
            Arrays.sort(cArr);
            String sorted = new String(cArr);
            if(anagrams.containsKey(sorted)){
                anagrams.get(sorted).add(strs[i]);
            }else{
                anagrams.put(sorted,new ArrayList<>());
                anagrams.get(sorted).add(strs[i]);
            }
        }
    List<List<String>> result = new ArrayList<>();

    for(var entry:anagrams.entrySet()){
        result.add(entry.getValue());
    }
    return result;
    }
}

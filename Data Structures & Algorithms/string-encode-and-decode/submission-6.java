class Solution {
      List<String> result = new ArrayList<>();

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str:strs){
            sb.append(str.length()+"#"+str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
         int i=0;
        while(i<str.length()){
        int j=i;
        while(str.charAt(j)!='#'){
            j++;
        }
     
       int len = Integer.valueOf(str.substring(i,j));
        i=j+1;
        j = i+len;
        result.add(str.substring(i,j));
        i=j;
    }
    return result;
    }
   
}

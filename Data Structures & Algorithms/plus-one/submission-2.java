class Solution {
    public int[] plusOne(int[] digits) {
      reverse(digits); 
      List<Integer> result = new ArrayList<>();
      int carry = 0;
      int sum = 0;

      for(int i=0;i<digits.length;i++){
        if(i==0){
            sum = digits[i]+1;

        }else{
            sum+=digits[i];
        }
        sum+=carry;
        result.add(sum%10);
        carry = sum/10;
        sum=0;
      }
      if(carry!=0){
        result.add(carry);
      }

      Collections.reverse(result);

      return result.stream().mapToInt(Integer::intValue).toArray();

    }

    public void reverse(int[] digits){
        int l= 0;
        int r = digits.length-1;
        while(l<r){
            int t = digits[r];
            digits[r] = digits[l];
            digits[l] = t;
            l++;
            r--;
        }

    }
}

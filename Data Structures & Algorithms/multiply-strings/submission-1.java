class Solution {
    public String multiply(String num1, String num2) {
          if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int n = num1.length();
        int m = num2.length();
        int[] res = new int[n+m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int digit = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                res[i+j]+=digit;
                res[i+j+1]+=res[i+j]/10;
                res[i+j]%=10;
            }
        }
  StringBuilder result = new StringBuilder();
        int i = res.length - 1;
        while (i >= 0 && res[i] == 0) {
            i--;
        }
        while(i>=0){
            result.append(res[i]);
            i--;
        }

        return result.toString();
    }
}

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int l1 = num1.length();
        int l2 = num2.length();

        int[] res = new int[l1 + l2];

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        // Multiply each digit
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                res[i + j] += digit1 * digit2;
            }
        }

        // Handle carries
        for (int i = 0; i < res.length - 1; i++) {
            res[i + 1] += res[i] / 10;
            res[i] %= 10;
        }

        // Remove leading zeros
        int k = res.length - 1;
        while (k >= 0 && res[k] == 0) {
            k--;
        }

        // Build answer
        StringBuilder result = new StringBuilder();

        while (k >= 0) {
            result.append(res[k]);
            k--;
        }

        return result.toString();
    }
}
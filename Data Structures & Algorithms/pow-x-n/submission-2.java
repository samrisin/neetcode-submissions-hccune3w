public class Solution {
    public double myPow(double x, int n) {
        long N = n; // handle overflow for Integer.MIN_VALUE
        
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1;

        while (N > 0) {
            // If current bit is 1
            if ((N % 2) == 1) {
                result *= x;
            }

            // Square the base
            x *= x;

            // Move to next bit
            N /= 2;
        }

        return result;
    }
}
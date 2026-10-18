 /*
  * Problem: 326. Power of Three
  * Link: https://leetcode.com/problems/power-of-three/
  *
  * Approach:
  * 1. If n <= 0, return false because powers of three are positive.
  * 2. If n == 1, return true because 3^0 = 1.
  * 3. If n is not divisible by 3, return false.
  * 4. Otherwise, divide n by 3 and recursively check the result.
  * 5. Repeat until a base case is reached.
  *
  * Time Complexity: O(log₃ n)
  * Space Complexity: O(log₃ n) due to the recursion stack.
  */

class Solution {
    public boolean isPowerOfThree(int n) {
        // Base case
        if (n <= 0) return false;
        if (n == 1) return true;

        // Self work
        if (n % 3 != 0) return false;

        // Recursive work
        return isPowerOfThree(n / 3);
    }
}

/*
Problem: 1979. Find Greatest Common Divisor of Array
Link: https://leetcode.com/problems/find-greatest-common-divisor-of-array/

Approach:
1. Initialize min with Integer.MAX_VALUE and max with Integer.MIN_VALUE.
2. Traverse the array to find the smallest and largest elements.
3. Calculate the GCD of min and max using the Euclidean Algorithm.
4. If y becomes 0, return x as the GCD.
5. Otherwise, recursively call gcd(y, x % y).
6. Return the final GCD.

Time Complexity: O(n + log(max))
Space Complexity: O(log(max)) due to recursive function calls.
*/

class Solution {

    // Euclidean Algorithm to calculate GCD
    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public int findGCD(int[] nums) {

        // Find the smallest and largest elements
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }

            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // Calculate GCD of the smallest and largest elements
        int result = gcd(min, max);

        return result;
    }
}

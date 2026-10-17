
/*
Problem: 1342. Number of Steps to Reduce a Number to Zero
Link: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

Approach:
1. If num is 0, return 0 because no steps are required.
2. If num is even, divide it by 2 and count one step.
3. If num is odd, subtract 1 and count one step.
4. Repeat recursively until num becomes 0.
5. Add 1 for every operation performed.

Time Complexity: O(log n)
Space Complexity: O(log n) due to the recursion stack.
*/

class Solution {
    public int numberOfSteps(int num) {

        // Base case
        if (num == 0) {
            return 0;
        }

        // If num is even, divide by 2
        if (num % 2 == 0) {
            return 1 + numberOfSteps(num / 2);
        } else {
            // If num is odd, subtract 1
            return 1 + numberOfSteps(num - 1);
        }
    }
}

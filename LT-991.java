/*
Problem: 991. Broken Calculator
Link: https://leetcode.com/problems/broken-calculator/

Approach:
1. Start from target and work backward toward startValue.
2. If target is even, divide it by 2 and increment operation.
3. If target is odd, add 1 to make it even and increment operation.
4. Continue until target <= startValue.
5. When the loop ends, only decrement operations are needed to reach target from startValue.
6. Return operation + (startValue - target).

Time Complexity: O(log target + startValue - target)
Space Complexity: O(1)
*/

class Solution {
    public int brokenCalc(int startValue, int target) {
        int operation = 0;

        // Work backward from target
        while (target > startValue) {
            if (target % 2 == 0) {
                target = target / 2;
                operation++;
            } else {
                target = target + 1;
                operation++;
            }
        }

        // Remaining operations are decrements
        return operation + (startValue - target);
    }
}

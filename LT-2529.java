/*
Problem: 2529. Maximum Count of Positive Integer and Negative Integer
Link: https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/

Approach:
1. Traverse the array once.
2. If the number is negative, increase the negative count.
3. If the number is positive, increase the positive count.
4. Ignore zero because it is neither positive nor negative.
5. Return the maximum of the two counts.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maximumCount(int[] nums) {
        int positiveNum = 0;
        int negativeNum = 0;

        for (int x : nums) {
            if (x < 0) {
                negativeNum++;
            } else if (x > 0) {
                positiveNum++;
            }
        }

        return Math.max(positiveNum, negativeNum);
    }
}

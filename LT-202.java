/*
Problem: 202. Happy Number
Link: https://leetcode.com/problems/happy-number/

Approach:
- Use Floyd's Cycle Detection algorithm with slow and fast pointers.
- slow moves one step, while fast moves two steps.
- If n is a happy number, the cycle ends at 1.
- Otherwise, slow and fast meet at another number in the cycle.

Time Complexity: O(log n) per iteration
Space Complexity: O(1)
*/

class Solution {
    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        do {
            slow = getNext(slow);
            fast = getNext(getNext(fast));

        } while (slow != fast);

        return slow == 1;
    }

    private int getNext(int n) {

        int sum = 0;

        while (n > 0) {

            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}

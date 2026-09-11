/*
Problem: 287. Find the Duplicate Number
Link: https://leetcode.com/problems/find-the-duplicate-number/

Approach:
- Treat the array like a linked list where nums[i] points to nums[nums[i]].
- Use Floyd's Cycle Detection algorithm.
- First, move slow by 1 step and fast by 2 steps until they meet.
- Then reset slow to nums[0].
- Move both one step at a time.
- The point where they meet is the duplicate number.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int findDuplicate(int[] nums) {

        // Step 1: Find intersection point inside the cycle

        int slow = nums[0];
        int fast = nums[0];

        do {
            // slow moves 1 step
            slow = nums[slow];

            // fast moves 2 steps
            fast = nums[fast];
            fast = nums[fast];

        } while (slow != fast);


        // Step 2: Find the entrance of the cycle

        slow = nums[0];

        while (slow != fast) {

            slow = nums[slow];
            fast = nums[fast];
        }

        // Cycle entrance = duplicate number
        return slow;
    }
}

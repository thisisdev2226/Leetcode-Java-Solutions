/*
Problem: 496. Next Greater Element I
Link: https://leetcode.com/problems/next-greater-element-i/

Approach:
- Use a Monotonic Stack and HashMap.
- Traverse nums2 from left to right.
- Maintain a decreasing stack of elements whose next greater
  element has not been found yet.
- When the current number is greater than the stack top,
  current number is the next greater element of stack top.
- Store the result in HashMap.
- Remaining elements in the stack have no greater element,
  so map them to -1.
- Finally, use the HashMap to build the answer for nums1.

Time Complexity: O(n + m)
- n = nums1.length
- m = nums2.length
- Each element of nums2 is pushed and popped at most once.

Space Complexity: O(m)
- Stack and HashMap can store up to m elements.
*/

import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Find next greater element for nums2
        for (int num : nums2) {

            // Current number is greater than stack top
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }

            // Add current number to stack
            stack.push(num);
        }

        // Remaining elements have no next greater element
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Build answer for nums1
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}

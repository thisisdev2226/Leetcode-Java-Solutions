/*
 * Problem: 503. Next Greater Element II
 * Link: https://leetcode.com/problems/next-greater-element-ii/
 *
 * Approach:
 * 1. Since the array is circular, elements after the last index
 *    can continue from the beginning of the array.
 *
 * 2. First, push all elements into the stack from right to left.
 *    This gives us the elements from the beginning of the array
 *    available when we process the end of the array.
 *
 * 3. Traverse the array from right to left.
 *
 * 4. Remove all elements from the stack that are smaller than or
 *    equal to nums[i], because they cannot be the next greater element.
 *
 * 5. If the stack is empty, there is no greater element, so store -1.
 *    Otherwise, the top of the stack is the next greater element.
 *
 * 6. Push nums[i] into the stack for the elements to its left.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] newarr = new int[n];

        Stack<Integer> st = new Stack<>();

        // Put all elements into stack first
        // to handle the circular nature of the array
        for (int i = n - 1; i >= 0; i--) {
            st.push(nums[i]);
        }

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove elements that cannot be the answer
            while (st.size() > 0 && nums[i] >= st.peek()) {
                st.pop();
            }

            // No greater element found
            if (st.size() == 0) {
                newarr[i] = -1;
            } 
            // Top is the next greater element
            else {
                newarr[i] = st.peek();
            }

            // Add current element for the next iterations
            st.push(nums[i]);
        }

        return newarr;
    }
}

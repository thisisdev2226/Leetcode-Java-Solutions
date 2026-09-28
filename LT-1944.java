/*
 * Problem: 1944. Number of Visible People in a Queue
 * Link: https://leetcode.com/problems/number-of-visible-people-in-a-queue/
 *
 * Approach:
 * 1. Traverse the array from right to left because each person can see
 *    people only towards their right.
 *
 * 2. Use a monotonic decreasing stack to store heights of people
 *    who can potentially be visible.
 *
 * 3. For every person:
 *    - Pop all people whose height is <= current height.
 *    - Every popped person is visible, so increment count.
 *
 * 4. After popping, if the stack is not empty, the remaining person
 *    is also visible because this person is taller than the current person.
 *    This is why we do:
 *        if (st.size() > 0) count++;
 *
 * 5. Store the count in ans[i] and push the current person's height.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int[] canSeePersonsCount(int[] heights) {

        int n = heights.length;

        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        // Last person cannot see anyone
        st.push(heights[n - 1]);
        ans[n - 1] = 0;

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {

            int count = 0;

            // All shorter/equal people can be seen
            while (st.size() > 0 && st.peek() <= heights[i]) {
                count++;
                st.pop();
            }

            // The first taller person is also visible
            if (st.size() > 0) {
                count++;
            }

            ans[i] = count;

            // Add current person to stack
            st.push(heights[i]);
        }

        return ans;
    }
}

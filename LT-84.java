/**
 * Problem: 84. Largest Rectangle in Histogram
 * Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Approach (Optimized - Single Pass Stack):
 * - Use a monotonic increasing stack storing indices
 * - Traverse all bars + one extra iteration (i == n)
 * - While current height is smaller than stack top:
 *     → Pop index
 *     → Calculate area using popped height
 *
 * - Width calculation:
 *     if stack empty → width = i
 *     else → width = i - stack.peek() - 1
 *
 * - Keep updating max area
 *
 * Key Insight:
 * - When a smaller element appears, it finalizes rectangles
 *   for all taller bars before it
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            // Treat height = 0 when i == n to flush stack
            int currHeight = (i == n) ? 0 : heights[i];

            while (!st.isEmpty() && heights[st.peek()] > currHeight) {
                int height = heights[st.pop()];

                int width;
                if (st.isEmpty()) {
                    width = i; // from 0 to i-1
                } else {
                    width = i - st.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            st.push(i);
        }

        return maxArea;
    }
}

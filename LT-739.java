/*
Problem: 739. Daily Temperatures
Link: https://leetcode.com/problems/daily-temperatures/

Approach:
- Use a Monotonic Stack to find the next warmer temperature.
- Traverse the array from right to left.
- Store indices in the stack, maintaining temperatures in decreasing order.
- Pop all indices whose temperature is less than or equal to the current temperature.
- If the stack is not empty, the top index represents the next warmer day.
- The answer is the distance between the current index and the top index.

Time Complexity: O(n)
- Each index is pushed and popped at most once.

Space Complexity: O(n)
- Stack can contain up to n indices.
*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove temperatures that are not warmer
            while (!st.isEmpty() &&
                   temperatures[i] >= temperatures[st.peek()]) {
                st.pop();
            }

            // If stack is not empty, next warmer day exists
            if (!st.isEmpty()) {
                res[i] = st.peek() - i;
            }

            // Store current index
            st.push(i);
        }

        return res;
    }
}

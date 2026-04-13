 /*
    Problem No: 42
    Problem Name: Trapping Rain Water
    Link: https://leetcode.com/problems/trapping-rain-water/

    Approach:
    - Use Two Pointer technique
    - Maintain two pointers:
        l (left) and r (right)
    - Track:
        leftMax → maximum height from left
        rightMax → maximum height from right

    - Logic:
        - If height[l] <= height[r]:
            - If height[l] >= leftMax → update leftMax
            - Else → water trapped = leftMax - height[l]
            - Move l++
        - Else:
            - If height[r] >= rightMax → update rightMax
            - Else → water trapped = rightMax - height[r]
            - Move r--

    - Why this works:
        - Water trapped depends on the smaller boundary
        - So we always process the smaller side first

    Time Complexity:
    - O(n) → single pass

    Space Complexity:
    - O(1) → no extra space used
    */

class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int leftMax = 0, rightMax = 0;
        int l = 0, r = n - 1;
        int ans = 0;

        while (l < r) {

            if (height[l] <= height[r]) {

                if (height[l] >= leftMax) {
                    leftMax = height[l];
                } else {
                    ans += leftMax - height[l];
                }
                l++;

            } else {

                if (height[r] >= rightMax) {
                    rightMax = height[r];
                } else {
                    ans += rightMax - height[r];
                }
                r--;
            }
        }

        return ans;
    }
}

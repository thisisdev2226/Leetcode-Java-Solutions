/*
Problem: 845. Longest Mountain in Array
Link: https://leetcode.com/problems/longest-mountain-in-array/

Approach:
1. Traverse the array from index 1 to n-2 because the first and last
   elements cannot be the peak of a mountain.
2. Check whether arr[i] is a peak:
      arr[i-1] < arr[i] && arr[i] > arr[i+1]
3. If it is a peak:
   - Expand left while the sequence is increasing.
   - Expand right while the sequence is decreasing.
4. Calculate the mountain length as:
      right - left + 1
5. Keep track of the maximum mountain length.

Time Complexity: O(n^2) in the worst case
Space Complexity: O(1)
*/

class Solution {
    public int longestMountain(int[] arr) {

        int n = arr.length;
        int maxLen = 0;

        // First and last index cannot be the peak
        for (int i = 1; i < n - 1; i++) {

            // Check if arr[i] is a peak
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {

                int left = i;
                int right = i;

                // Expand left (increasing part)
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                // Expand right (decreasing part)
                while (right < n - 1 && arr[right + 1] < arr[right]) {
                    right++;
                }

                // Calculate mountain length
                maxLen = Math.max(maxLen, right - left + 1);

                // Optional optimization:
                // i = right;
            }
        }

        return maxLen;
    }
}
```

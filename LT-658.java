/*
Problem: 658. Find K Closest Elements
Link: https://leetcode.com/problems/find-k-closest-elements/

Approach:
1. Since the array is sorted, use Binary Search to find the starting
   index of a window of size k.
2. Search between index 0 and arr.length - k.
3. For each possible window, compare:
      x - arr[mid]
   with:
      arr[mid + k] - x
4. If the right element is closer to x, move the window right.
5. Otherwise, keep searching on the left side.
6. Finally, return the k elements starting from the calculated left index.

Time Complexity: O(log(n - k) + k)
Space Complexity: O(k)
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0;
        int right = arr.length - k;

        // Binary search for the starting index of the window
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Compare the elements at both ends of the possible window
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Build the result using the best window
        List<Integer> result = new ArrayList<>();

        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}

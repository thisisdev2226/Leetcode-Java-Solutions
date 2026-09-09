/*
 * Problem: 852. Peak Index in a Mountain Array
 *
 * Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/
 *
 * Approach:
 * - Use Binary Search because the array first increases and then decreases.
 * - If arr[mid] > arr[mid - 1] and arr[mid] > arr[mid + 1],
 *   then mid is the peak, so return mid.
 * - If arr[mid] < arr[mid + 1], we are on the increasing side,
 *   so move right: low = mid + 1.
 * - Otherwise, we are on the decreasing side,
 *   so move left: high = mid - 1.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int n = arr.length;

        // First and last elements cannot be the peak
        int low = 1;
        int high = n - 2;

        while (low <= high) {
            
            int mid = low + (high - low) / 2;

            // Found the peak
            if (arr[mid] > arr[mid - 1] && 
                arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // We are on the increasing side
            else if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            }

            // We are on the decreasing side
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}

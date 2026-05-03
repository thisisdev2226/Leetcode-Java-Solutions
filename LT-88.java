/**
 * Problem: 88. Merge Sorted Array
 * Link: https://leetcode.com/problems/merge-sorted-array/
 *
 * Approach:
 * - Use three pointers starting from the end:
 *   i → last valid element in nums1 (m - 1)
 *   j → last element in nums2 (n - 1)
 *   k → last position in nums1 (m + n - 1)
 *
 * - Compare elements from back:
 *     - Place the larger element at index k
 *     - Move pointers accordingly
 *
 * - If nums2 still has elements left, copy them
 *
 * - No need to copy remaining nums1 elements
 *   because they are already in correct position
 *
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;       // pointer for nums1
        int j = n - 1;       // pointer for nums2
        int k = m + n - 1;   // pointer for merged array

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If nums2 still has elements
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}

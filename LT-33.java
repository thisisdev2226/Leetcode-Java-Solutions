/*
🔹 Problem: Search in Rotated Sorted Array
🔹 Link: https://leetcode.com/problems/search-in-rotated-sorted-array/

🔹 Approach:
- Use Binary Search.
- At every step, check which half is sorted:
  1. If left half is sorted:
     - Check if target lies in this range → move left
     - Else → move right
  2. Else right half is sorted:
     - Check if target lies in this range → move right
     - Else → move left
- Repeat until found or search space ends.

🔹 Time Complexity: O(log n)
🔹 Space Complexity: O(1)
*/

class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target)
                return mid;
            
            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } 
            // Right half is sorted
            else {
                
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        
        return -1;
    }
}

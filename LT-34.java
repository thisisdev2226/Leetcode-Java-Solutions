/*
🔹 Problem: Find First and Last Position of Element in Sorted Array
🔹 Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

🔹 Approach:
- Use Binary Search twice:
  1. First Binary Search → find the first occurrence
     - When found, store index and move LEFT (high = mid - 1)
  2. Second Binary Search → find the last occurrence
     - When found, store index and move RIGHT (low = mid + 1)
- If target not found, return [-1, -1]

🔹 Time Complexity: O(log n)
🔹 Space Complexity: O(1)
*/

class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findFirst(nums, target);
        ans[1] = findLast(nums, target);
        return ans;
    }
    
    private int findFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int first = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                first = mid;
                high = mid - 1; // move left
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return first;
    }
    
    private int findLast(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int last = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                last = mid;
                low = mid + 1; // move right
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return last;
    }
}

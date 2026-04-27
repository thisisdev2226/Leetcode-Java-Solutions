/**
 * Problem: 75. Sort Colors
 * Link: https://leetcode.com/problems/sort-colors/
 *
 * Approach:
 * - Use Dutch National Flag Algorithm (3-pointer approach).
 * - Maintain three pointers:
 *      start -> next position for 0
 *      mid   -> current element
 *      end   -> next position for 2
 *
 * - Traverse while mid <= end:
 *      If nums[mid] == 0:
 *          swap(start, mid), increment both start & mid
 *
 *      If nums[mid] == 1:
 *          just move mid forward
 *
 *      If nums[mid] == 2:
 *          swap(mid, end), decrement end ONLY
 *          (Do NOT increment mid here)
 *
 * - Why no mid++ when nums[mid] == 2?
 *      After swapping, the new element at mid is unknown (0,1,2),
 *      so we must re-check it.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    private void swap(int[] arr, int pos1, int pos2){
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public void sortColors(int[] nums) {

        int start = 0;
        int mid = 0;
        int end = nums.length - 1;

        while(mid <= end){

            if(nums[mid] == 0){
                swap(nums, start, mid);
                start++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{ // nums[mid] == 2
                swap(nums, mid, end);
                end--;
            }
        }
    }
}

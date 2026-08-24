/*
    Problem: 215. Kth Largest Element in an Array
    Link: https://leetcode.com/problems/kth-largest-element-in-an-array/

    Approach:
    - Use a Min Heap of size k.
    - Add each element from the array into the Min Heap.
    - If the heap size becomes greater than k, remove the smallest element.
    - After processing all elements, the heap contains the k largest elements.
    - The smallest element among them, i.e. pq.peek(), is the Kth largest element.

    Time Complexity: O(n log k)
    Space Complexity: O(k)
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {

        // Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add elements and maintain heap size of k
        for (int ele : nums) {
            pq.add(ele);

            // Remove the smallest element if size exceeds k
            if (pq.size() > k) {
                pq.remove();
            }
        }

        // Top of Min Heap is the Kth largest element
        return pq.peek();
    }
}

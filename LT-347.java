/*
Problem: 347. Top K Frequent Elements
Link: https://leetcode.com/problems/top-k-frequent-elements/

Approach:
1. Use a HashMap to store the frequency of each element.
2. Use a Min Heap (PriorityQueue) based on element frequency.
3. Add each unique element to the heap.
4. If heap size exceeds k, remove the element with the lowest frequency.
5. The remaining k elements are the k most frequent elements.

Time Complexity: O(n log k)
Space Complexity: O(n)
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        // Min Heap based on frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        // Keep only top k frequent elements
        for (int ele : map.keySet()) {
            pq.add(ele);

            if (pq.size() > k) {
                pq.remove();
            }
        }

        // Store result
        int[] ans = new int[k];
        int i = 0;

        while (!pq.isEmpty()) {
            ans[i++] = pq.remove();
        }

        return ans;
    }
}

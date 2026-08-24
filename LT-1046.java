/*
    Problem: 1046. Last Stone Weight
    Link: https://leetcode.com/problems/last-stone-weight/

    Approach:
    - Use a Max Heap (PriorityQueue with reverse order) because we always
      need to pick the two heaviest stones.
    - Insert all stones into the Max Heap.
    - While more than one stone exists:
        1. Remove the heaviest stone.
        2. Remove the second heaviest stone.
        3. If they have different weights, add their difference back.
    - Finally, return the remaining stone's weight or 0 if no stone remains.

    Time Complexity: O(n log n)
    Space Complexity: O(n)
*/

class Solution {
    public int lastStoneWeight(int[] stones) {

        // Max Heap because we always need the heaviest stones
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the Max Heap
        for (int stone : stones) {
            pq.add(stone);
        }

        // Smash the two heaviest stones
        while (pq.size() > 1) {

            int firstHeaviest = pq.remove();
            int secondHeaviest = pq.remove();

            // If stones are not equal, add the remaining weight back
            if (firstHeaviest != secondHeaviest) {
                pq.add(firstHeaviest - secondHeaviest);
            }
        }

        // Return the remaining stone weight, otherwise 0
        return pq.isEmpty() ? 0 : pq.peek();
    }
}

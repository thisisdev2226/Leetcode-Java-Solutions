/*
 * Problem: 1823. Find the Winner of the Circular Game
 * Link: https://leetcode.com/problems/find-the-winner-of-the-circular-game/
 *
 * Approach:
 * 1. Add all players from 1 to n into a Queue.
 * 2. While more than one player remains:
 *    - Move the first k - 1 players to the back of the queue.
 *    - Remove the kth player because that player is eliminated.
 * 3. When only one player remains, return the player at the front.
 *
 * Time Complexity: O(N * K)
 * Space Complexity: O(N)
 */

class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        // Add all players to the queue
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        // Continue until only one player remains
        while (q.size() > 1) {

            // Move k - 1 players from front to back
            for (int i = 1; i <= k - 1; i++) {
                q.add(q.remove());
            }

            // Remove the kth player
            q.remove();
        }

        // The remaining player is the winner
        return q.peek();
    }
}

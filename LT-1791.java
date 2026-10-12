/*
Problem: 1791. Find Center of Star Graph
Link: https://leetcode.com/problems/find-center-of-star-graph/

Approach:
1. In a star graph, one central node is directly connected to every other node.
2. Take the first two edges: edges[0] and edges[1].
3. The center must be a common vertex between these two edges.
4. If pair1[0] matches either vertex of pair2, return pair1[0].
5. Otherwise, return pair1[1], because it must be the center.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public int findCenter(int[][] edges) {

        int pair1[] = edges[0];  // First edge: v1, v2
        int pair2[] = edges[1];  // Second edge: v1, v2 or v2, v3

        // Check whether pair1[0] is common in both edges
        if (pair1[0] == pair2[0] || pair1[0] == pair2[1]) {
            return pair1[0];
        }

        // If pair1[0] is not common, pair1[1] must be the center
        return pair1[1];
    }
}

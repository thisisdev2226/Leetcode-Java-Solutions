/**
 * Problem: 134. Gas Station
 * Link: https://leetcode.com/problems/gas-station/
 *
 * Approach:
 * 1. First calculate total gas and total cost.
 *    - If total gas < total cost, completing the circuit is impossible.
 * 2. Traverse all stations while maintaining currentGas.
 *    - currentGas += gas[i] - cost[i]
 * 3. If currentGas becomes negative:
 *    - Current starting point is invalid.
 *    - Reset currentGas to 0.
 *    - Set next station as new starting index.
 * 4. Return the valid starting index.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int totalCost = 0;

        // Calculate total gas and total cost
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        // If total gas is less than total cost,
        // completing the circuit is impossible
        if (totalGas < totalCost) {
            return -1;
        }

        int currentGas = 0;
        int startIndex = 0;

        // Find valid starting station
        for (int i = 0; i < gas.length; i++) {

            currentGas += gas[i] - cost[i];

            // If current gas becomes negative,
            // reset and choose next station
            if (currentGas < 0) {
                startIndex = i + 1;
                currentGas = 0;
            }
        }

        // Return valid starting index
        return startIndex;
    }
}

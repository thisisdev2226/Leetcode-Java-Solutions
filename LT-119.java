/**
 * Problem: 119. Pascal's Triangle II
 * Link: https://leetcode.com/problems/pascals-triangle-ii/
 *
 * Approach:
 * - Create the complete Pascal Triangle up to rowIndex.
 * - Initialize all elements with 1.
 * - First and last element of every row remains 1.
 * - Middle elements are calculated using:
 *      arr[i][j] = arr[i-1][j] + arr[i-1][j-1]
 * - Return the required row.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(n²)
 */

class Solution {

    public List<Integer> getRow(int rowIndex) {

        int n = rowIndex + 1;

        List<List<Integer>> ans = new ArrayList<>();

        // Create rows and fill with 1
        for (int i = 0; i < n; i++) {

            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                list.add(1);
            }

            ans.add(list);
        }

        // Fill Pascal Triangle values
        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= i; j++) {

                // Boundary elements
                if (j == 0 || j == i) {
                    ans.get(i).set(j, 1);
                } 
                else {

                    int val = ans.get(i - 1).get(j)
                            + ans.get(i - 1).get(j - 1);

                    ans.get(i).set(j, val);
                }
            }
        }

        return ans.get(rowIndex);
    }
}

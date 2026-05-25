/**
 * Problem: 118. Pascal's Triangle
 * Link: https://leetcode.com/problems/pascals-triangle/
 *
 * Approach:
 * - Create the triangle row by row.
 * - First and last element of every row is always 1.
 * - For middle elements:
 *      triangle[i][j] = triangle[i-1][j] + triangle[i-1][j-1]
 * - Store each row inside the main answer list.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(n²)
 */

class Solution {
    public List<List<Integer>> generate(int n) {

        List<List<Integer>> ans = new ArrayList<>();

        // Generate each row
        for (int i = 0; i < n; i++) {

            // Create new row
            ans.add(new ArrayList<>());

            for (int j = 0; j <= i; j++) {

                // First and last element is always 1
                if (j == 0 || j == i) {
                    ans.get(i).add(1);
                } 
                else {

                    // Sum of upper two elements
                    int val = ans.get(i - 1).get(j)
                            + ans.get(i - 1).get(j - 1);

                    ans.get(i).add(val);
                }
            }
        }

        return ans;
    }
}

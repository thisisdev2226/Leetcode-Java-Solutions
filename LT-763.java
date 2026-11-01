/*
Problem: 763. Partition Labels
Link: https://leetcode.com/problems/partition-labels/

Approach: Greedy

1. Create an ArrayList to store the size of each partition.

2. Traverse the string using a while-style for loop:
   - Store the current index as startIndex.
   - Find the last occurrence of the starting character using lastIndexOf().
   - This becomes the initial endIndex.

3. Traverse from startIndex + 1 to endIndex:
   - Find the last occurrence of each character.
   - If its last occurrence is greater than the current endIndex,
     update endIndex.
   - This ensures that every occurrence of characters in the
     current partition is included.

4. Once the partition is complete:
   - Calculate its length using endIndex - startIndex + 1.
   - Add the length to the answer list.
   - Move i to endIndex + 1 to start the next partition.

5. Return the answer list.

Time Complexity: O(n²) in the worst case
Space Complexity: O(1) auxiliary space (excluding the output list)
*/

class Solution {
    public List<Integer> partitionLabels(String s) {

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < s.length();) {

            int startIndex = i;

            int endIndex = s.lastIndexOf(s.charAt(startIndex));

            for (int j = startIndex + 1; j <= endIndex - 1; j++) {

                int lastIndexOfNextChar = s.lastIndexOf(s.charAt(j));

                if (lastIndexOfNextChar > endIndex) {
                    endIndex = lastIndexOfNextChar;
                }
            }

            ans.add(endIndex - startIndex + 1);

            i = endIndex + 1;
        }

        return ans;
    }
}

/*
Problem: Jewels and Stones (LeetCode 771)

Link: https://leetcode.com/problems/jewels-and-stones/

Approach:
1. Create a HashSet to store all jewel characters.
2. Traverse the jewels string and add each character to the HashSet.
3. Traverse the stones string and check whether each character exists in the HashSet.
4. If a character exists, increment the count because that stone is a jewel.
5. Return the total count.

Time Complexity: O(J + S)
- J = Length of jewels
- S = Length of stones
- HashSet insertion and lookup take O(1) on average.

Space Complexity: O(J)
- HashSet stores at most J characters.
*/

class Solution {
    public int numJewelsInStones(String jewels, String stones) {

        HashSet<Character> set = new HashSet<>();

        // Store all jewel characters in HashSet
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        int count = 0;

        // Check which stones are jewels
        for (int i = 0; i < stones.length(); i++) {

            if (set.contains(stones.charAt(i))) {
                count++;
            }
        }

        return count;
    }
}

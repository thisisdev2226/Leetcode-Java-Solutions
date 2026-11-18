/*
Problem: 187. Repeated DNA Sequences
Link: https://leetcode.com/problems/repeated-dna-sequences/

Approach: HashSet

1. Create two HashSets:
   - seen: Stores DNA sequences that have already appeared.
   - result: Stores DNA sequences that appear more than once.

2. Traverse the string using a sliding window of size 10.

3. Extract a substring of length 10 using:
   s.substring(i, i + 10)

4. Check whether the substring already exists in the seen set:
   - If yes, add it to the result set.
   - Otherwise, add it to the seen set.

5. Return the result set as an ArrayList.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        HashSet<String> seen = new HashSet<>();
        HashSet<String> result = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {

            String sub = s.substring(i, i + 10);

            if (seen.contains(sub)) {
                result.add(sub);
            } else {
                seen.add(sub);
            }
        }

        return new ArrayList<>(result);
    }
}

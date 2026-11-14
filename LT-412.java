/*
Problem: 412. Fizz Buzz
Link: https://leetcode.com/problems/fizz-buzz/

Approach:
1. Create an ArrayList to store the result as strings.
2. Run a for loop from 1 to n.
3. For every number, check the following conditions:

   a) If the number is divisible by both 3 and 5:
      - Add "FizzBuzz" to the result.

   b) If the number is divisible by 3:
      - Add "Fizz" to the result.

   c) If the number is divisible by 5:
      - Add "Buzz" to the result.

   d) Otherwise:
      - Convert the number into a String using Integer.toString()
        and add it to the result.

4. Return the result list.

Important:
- Always check the divisibility by both 3 and 5 first.
- Otherwise, numbers divisible by both may be handled by
  only one of the individual conditions.

Time Complexity: O(n)
- We traverse from 1 to n exactly once.
- Each iteration performs constant-time operations.

Space Complexity: O(n)
- We store n strings in the result list.
*/

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");

            } else if (i % 3 == 0) {
                result.add("Fizz");

            } else if (i % 5 == 0) {
                result.add("Buzz");

            } else {
                result.add(Integer.toString(i));
            }
        }

        return result;
    }
}

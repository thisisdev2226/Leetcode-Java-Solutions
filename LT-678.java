/*
Problem: 678. Valid Parenthesis String
Link: https://leetcode.com/problems/valid-parenthesis-string/

Approach: Greedy using Two Stacks

1. Create two stacks:
   - extraOpenBrackets: Stores indices of '('.
   - aestrick: Stores indices of '*'.

2. Traverse the string:
   - If the current character is '(':
     Push its index into extraOpenBrackets.
   - If the current character is '*':
     Push its index into aestrick.
   - If the current character is ')':
     - First, match it with an available '(' by popping extraOpenBrackets.
     - If no '(' is available, use '*' as '(' by popping aestrick.
     - If neither stack has an element, return false.

3. After traversing the string:
   - Some opening brackets may remain unmatched.
   - Match each remaining '(' with a '*' that appears after it.
   - If no '*' is available, return false.
   - If the index of '(' is greater than the index of '*',
     return false because '*' cannot close a bracket appearing before it.

4. If all opening brackets are matched successfully, return true.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public boolean checkValidString(String s) {

        Stack<Integer> extraOpenBrackets = new Stack<>();
        Stack<Integer> aestrick = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                extraOpenBrackets.push(i);

            } else if (ch == '*') {
                aestrick.push(i);

            } else {

                // First preference: match with '('
                if (!extraOpenBrackets.isEmpty()) {
                    extraOpenBrackets.pop();

                } 
                // Otherwise, treat '*' as '('
                else if (!aestrick.isEmpty()) {
                    aestrick.pop();

                } else {
                    return false;
                }
            }
        }

        // Match remaining '(' with '*' appearing after them
        while (!extraOpenBrackets.isEmpty()) {

            if (aestrick.isEmpty()) {
                return false;
            }

            int openIndex = extraOpenBrackets.pop();
            int closeIndex = aestrick.pop();

            // '*' must appear after '('
            if (openIndex > closeIndex) {
                return false;
            }
        }

        return extraOpenBrackets.isEmpty();
    }
}

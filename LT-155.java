/*
Problem No: 155
Problem Name: Min Stack
Link: https://leetcode.com/problems/min-stack/

Approach:
- Use two stacks:
  1. stack     -> stores all elements.
  2. minStack  -> stores the minimum elements seen so far.
- While pushing:
  - Push the value into stack.
  - If minStack is empty or the new value is less than or equal to the current minimum,
    push it into minStack as well.
- While popping:
  - Remove the top element from stack.
  - If the popped element is equal to the top of minStack, remove it from minStack too.
- The top of minStack always represents the minimum element in the stack.

Time Complexity:
- push()   : O(1)
- pop()    : O(1)
- top()    : O(1)
- getMin() : O(1)

Space Complexity:
- O(n)
*/
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int poppedValue = stack.pop();

        if (poppedValue == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

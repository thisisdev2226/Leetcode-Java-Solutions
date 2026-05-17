/**
 * Problem: 109. Convert Sorted List to Binary Search Tree
 * Link: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * Approach:
 * 1. Traverse the linked list and store all values in an array.
 * 2. Since the array is sorted, use Binary Search Tree construction logic:
 *      - Middle element becomes root.
 *      - Left half forms left subtree.
 *      - Right half forms right subtree.
 * 3. Recursively build the BST using divide and conquer.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public TreeNode helper(int[] nums, int lo, int hi) {
        if (lo > hi) return null;

        int mid = (lo + hi) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums, lo, mid - 1);
        root.right = helper(nums, mid + 1, hi);

        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {

        // Calculate length of linked list
        ListNode temp = head;
        int n = 0;

        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // Store linked list values into array
        int[] nums = new int[n];

        temp = head;
        int i = 0;

        while (temp != null) {
            nums[i] = temp.val;
            i++;
            temp = temp.next;
        }

        // Build balanced BST
        return helper(nums, 0, n - 1);
    }
}

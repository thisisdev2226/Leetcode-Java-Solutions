/**
 * Problem: 84. Largest Rectangle in Histogram
 * Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Approach:
 * - Use Monotonic Stack to find:
 *   1. Next Smaller Element (NSE) for each index
 *   2. Previous Smaller Element (PSE) for each index
 *
 * - NSE[i]: index of next smaller element on right
 *   If none → use n (important for width calculation)
 *
 * - PSE[i]: index of previous smaller element on left
 *   If none → use -1
 *
 * - Width of rectangle with height heights[i]:
 *     width = nse[i] - pse[i] - 1
 *
 * - Area:
 *     area = heights[i] * width
 *
 * - Compute max area among all bars
 *
 * Key Insight:
 * - Each bar is treated as the smallest height in its rectangle
 * - Stack helps maintain increasing order of heights
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

/*
📌 Problem: 56. Merge Intervals
🔗 Link: https://leetcode.com/problems/merge-intervals/

💡 Approach:
1. Sort intervals based on starting time.
2. Initialize a result list and add the first interval.
3. Traverse remaining intervals:
   - If current interval overlaps with last merged interval → merge them.
   - Else → add as a new interval.
4. Convert list to array and return.

⏱ Time Complexity: O(n log n)  // due to sorting
🗂 Space Complexity: O(n)      // for storing result
*/

import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        // Edge case
        if (intervals.length <= 1) {
            return intervals;
        }

        // Step 1: Sort by start time
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        // Step 2: Result list
        ArrayList<int[]> result = new ArrayList<>();

        // Step 3: Start with first interval
        int[] newInterval = intervals[0];
        result.add(newInterval);

        // Step 4: Traverse and merge
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                // Overlapping → merge
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // No overlap → add new interval
                newInterval = interval;
                result.add(newInterval);
            }
        }

        // Step 5: Convert list to array
        return result.toArray(new int[result.size()][]);
    }
}

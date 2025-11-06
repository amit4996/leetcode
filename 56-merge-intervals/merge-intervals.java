class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals by the start value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            // If merged is empty or intervals do not overlap, append
            if (merged.isEmpty() || interval[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(interval);
            } else {
                // Overlap: update the end of the last merged interval
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        // Convert List<int[]> merged to int[][]
        return merged.toArray(new int[merged.size()][]);
    }
}
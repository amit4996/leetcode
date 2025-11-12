import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;

        // Iterate over all pairs of rows
        for (int r1 = 0; r1 < m; r1++) {
            int[] colSum = new int[n];

            for (int r2 = r1; r2 < m; r2++) {
                // Update column sums for this row range
                for (int c = 0; c < n; c++) {
                    colSum[c] += matrix[r2][c];
                }

                // Now count subarrays of colSum that sum to target
                count += countSubarraysWithSum(colSum, target);
            }
        }

        return count;
    }

    private int countSubarraysWithSum(int[] arr, int target) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : arr) {
            prefixSum += num;

            // Check if prefixSum - target exists
            if (prefixCount.containsKey(prefixSum - target)) {
                count += prefixCount.get(prefixSum - target);
            }

            // Store prefixSum occurrence
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
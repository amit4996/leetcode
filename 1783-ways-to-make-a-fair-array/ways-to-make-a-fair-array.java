class Solution {
    public int waysToMakeFair(int[] nums) {
        int totalEven = 0, totalOdd = 0;
        int n = nums.length;
        // Compute total sums at even and odd indices
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) totalEven += nums[i];
            else totalOdd += nums[i];
        }
        int leftEven = 0, leftOdd = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            // Remove current nums[i] and shift parity of right elements
            if (i % 2 == 0) totalEven -= nums[i];
            else totalOdd -= nums[i];

            // After removing nums[i]:
            // New even sum: leftEven + totalOdd (right odd indices flip)
            // New odd sum: leftOdd + totalEven (right even indices flip)
            if (leftEven + totalOdd == leftOdd + totalEven) ans++;

            // Restore totals
            if (i % 2 == 0) leftEven += nums[i];
            else leftOdd += nums[i];
        }
        return ans;
    }
}
class Solution {
    public long[] resultArray(int[] nums, int k) {
         long[] result = new long[k];
        long[] dp = new long[k];
        for (int num : nums) {
            long[] nextDp = new long[k];
            int mod = num % k;
            nextDp[mod]++;
            for (int i = 0; i < k; i++) {
                if (dp[i] > 0) {
                    nextDp[(i * mod) % k] += dp[i];
                }
            }
             for (int i = 0; i < k; i++) {
                result[i] += nextDp[i];
                dp[i] = nextDp[i];
            }
        }
        return result;
    }
}
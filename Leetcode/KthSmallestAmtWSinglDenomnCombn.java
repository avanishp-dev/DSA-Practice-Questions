class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        long[] lcms = new long[1 << n];
        int[] sign = new int[1 << n];
        lcms[0] = 1;
        long minCoin = coins[0];
        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }
        for (int i = 1; i < (1 << n); i++) {
            int lowestBit = Integer.lowestOneBit(i);
            int j = Integer.numberOfTrailingZeros(lowestBit);
            lcms[i] = lcm(lcms[i ^ lowestBit], coins[j]);
            sign[i] = Integer.bitCount(i) % 2 == 1 ? 1 : -1;
        }
        long low = 1;
        long high = (long) k * minCoin;
        long ans = high;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long count = 0;
            for (int i = 1; i < (1 << n); i++) {
                count += sign[i] * (mid / lcms[i]);
            }
            if (count >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}
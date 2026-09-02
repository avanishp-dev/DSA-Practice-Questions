class Solution {
    static int palindromicStrings(int n, int k) {
        final long MOD = 1000000007L;
        long ans = 0;
        long perm = 1;

        for (int m = 0; 2 * m + 1 <= n; m++) {
            if (m > 0) {
                perm = perm * (k - m) % MOD;
            }
            ans = (ans + k * perm) % MOD;
        }

        perm = 1;

        for (int m = 1; 2 * m <= n; m++) {
            perm = perm * (k - m + 1) % MOD;
            ans = (ans + perm) % MOD;
        }

        return (int) ans;
    }
}
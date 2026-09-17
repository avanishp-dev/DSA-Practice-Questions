class Solution {
    int M = 1000000007;
    public int numberOfSets(int n, int k) {
        long r = 1;
        for (int i = 1; i <= k * 2; i++)
            r = r * (n + k - i) % M * p(i, M - 2) % M;
        return (int) r;
    }
    long p(long b, int e) {
        long r = 1;
        while (e > 0) {
            if ((e & 1) == 1)
                r = r * b % M;
            b = b * b % M;
            e >>= 1;
        }
        return r;
    }
}
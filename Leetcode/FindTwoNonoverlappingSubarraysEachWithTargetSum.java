class Solution {
    public int minSumOfLengths(int[] a, int t) {
        int n = a.length, s = 0, l = 0, m = 999999, b = 999999;
        int[] d = new int[n];
        for (int r = 0; r < n; r++) {
            s += a[r];
            while (s > t)
                s -= a[l++];
            if (s == t) {
                int c = r - l + 1;
                if (l > 0)
                    m = Math.min(m, c + d[l - 1]);
                b = Math.min(b, c);
            }
            d[r] = b;
        }
        return m > n ? -1 : m;
    }
}
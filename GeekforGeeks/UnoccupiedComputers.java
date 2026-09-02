class Solution {
    static int solve(int n, String s) {
        boolean[] inside = new boolean[26];
        boolean[] rejected = new boolean[26];
        int available = n;
        int ans = 0;
        for (char ch : s.toCharArray()) {
            int idx = ch - 'A';
            if (!inside[idx] && !rejected[idx]) {
                if (available > 0) {
                    available--;
                    inside[idx] = true;
                } else {
                    rejected[idx] = true;
                    ans++;
                }
            } else if (inside[idx]) {
                inside[idx] = false;
                available++;
            }
        }
        return ans;
    }
}
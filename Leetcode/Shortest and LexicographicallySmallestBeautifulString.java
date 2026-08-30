class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0;
        int ones = 0;
        int best = n + 1;
        String ans = "";
        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1')
                ones++;
            while (ones > k) {
                if (s.charAt(left) == '1')
                    ones--;
                left++;
            }
            if (ones == k) {
                while (left <= right && s.charAt(left) == '0')
                    left++;
                int len = right - left + 1;
                if (len < best) {
                    best = len;
                    ans = s.substring(left, right + 1);
                } else if (len == best) {
                    String x = s.substring(left, right + 1);
                    if (ans.equals("") || x.compareTo(ans) < 0)
                        ans = x;
                }
            }
        }
        return ans;
    }
}
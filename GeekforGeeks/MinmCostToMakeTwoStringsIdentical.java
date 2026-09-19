class Solution {
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
        int n = s1.length();
        int m = s2.length();

        if (m > n) {
            String temp = s1;
            s1 = s2;
            s2 = temp;

            int c = costS1;
            costS1 = costS2;
            costS2 = c;

            n = s1.length();
            m = s2.length();
        }

        int[] dp = new int[m + 1];

        for (int j = 1; j <= m; j++)
            dp[j] = dp[j - 1] + costS2;

        for (int i = 1; i <= n; i++) {
            int diagonal = dp[0];
            dp[0] += costS1;

            for (int j = 1; j <= m; j++) {
                int old = dp[j];

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = diagonal;
                } else {
                    dp[j] = Math.min(
                        costS1 + dp[j],
                        Math.min(
                            costS2 + dp[j - 1],
                            costS1 + costS2 + diagonal
                        )
                    );
                }

                diagonal = old;
            }
        }

        return dp[m];
    }
}
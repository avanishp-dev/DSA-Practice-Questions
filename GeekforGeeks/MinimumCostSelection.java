class Solution {
    public int minCost(int[][] mat) {
        int n = mat.length;

        int dp0 = mat[0][0];
        int dp1 = mat[0][1];
        int dp2 = mat[0][2];

        for (int i = 1; i < n; i++) {
            int newDp0 = mat[i][0] + Math.min(dp1, dp2);
            int newDp1 = mat[i][1] + Math.min(dp0, dp2);
            int newDp2 = mat[i][2] + Math.min(dp0, dp1);

            dp0 = newDp0;
            dp1 = newDp1;
            dp2 = newDp2;
        }

        return Math.min(dp0, Math.min(dp1, dp2));
    }
}
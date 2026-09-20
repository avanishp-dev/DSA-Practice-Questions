class Solution {
    public int largestSubsquare(char[][] mat) {
        int n = mat.length;
        int[][] hor = new int[n][n];
        int[][] ver = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 'X') {
                    hor[i][j] = (j == 0) ? 1 : hor[i][j - 1] + 1;
                    ver[i][j] = (i == 0) ? 1 : ver[i - 1][j] + 1;
                }
            }
        }

        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int len = Math.min(hor[i][j], ver[i][j]);

                while (len > ans) {
                    if (ver[i][j - len + 1] >= len &&
                        hor[i - len + 1][j] >= len) {
                        ans = len;
                        break;
                    }
                    len--;
                }
            }
        }

        return ans;
    }
}
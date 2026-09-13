class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int ans = 0;
        for (int row = -n + 1; row < n; row++) {
            for (int col = -n + 1; col < n; col++) {
                int count = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int x = i + row;
                        int y = j + col;
                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            if (img1[i][j] == 1 && img2[x][y] == 1) {
                                count++;
                            }
                        }
                    }
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
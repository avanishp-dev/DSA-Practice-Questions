import java.util.Arrays;

 class Solution {
     public int maxArea(int[][] mat) {
         int n = mat.length;
         int m = mat[0].length;
         int[][] hist = new int[n][m];
         for (int j = 0; j < m; j++) {
             hist[0][j] = mat[0][j];
             for (int i = 1; i < n; i++) {
                 if (mat[i][j] == 1) {
                     hist[i][j] = hist[i - 1][j] + 1;
                 } else {
                     hist[i][j] = 0;
                 }
             }
         }
         int maxArea = 0;
         for (int i = 0; i < n; i++) {
             int[] row = hist[i];
             Arrays.sort(row);
             for (int j = 0; j < m; j++) {
                 int height = row[j];
                 int width = m - j;
                 int area = height * width;

                 if (area > maxArea) {
                     maxArea = area;
                 }
             }
         }

         return maxArea;
     }
 }

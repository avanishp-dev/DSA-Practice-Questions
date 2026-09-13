class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] temp= new int[n][n];
        int[][] answer= new int[n][n];
        for(int i=0;i<n;i++){
            int shift= rowShift[i];
            for(int j=0;j<n;j++){
                int newColumn=(j-shift+n)%n;
                temp[i][newColumn]=grid[i][j];
            }
        }
        for(int j=0;j<n;j++){
            int shift= colShift[j];
            for(int i=0;i<n;i++){
                int newRow=(i-shift+n)%n;
                answer[newRow][j]=temp[i][j];
            }
        }
        return answer;
    }
}
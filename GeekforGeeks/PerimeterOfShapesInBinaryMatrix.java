class Solution {
    static int findPerimeter(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int ans=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    ans+=4;
                    if(i>0&&mat[i-1][j]==1) ans--;
                    if(i<n-1&&mat[i+1][j]==1) ans--;
                    if(j>0&&mat[i][j-1]==1) ans--;
                    if(j<m-1&&mat[i][j+1]==1) ans--;
                }
            }
        }
        return ans;
    }
}
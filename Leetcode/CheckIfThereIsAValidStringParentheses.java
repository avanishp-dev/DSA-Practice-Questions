class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        int len=m+n-1;
        if(len%2==1||grid[0][0]==')'||grid[m-1][n-1]=='(') return false;
        boolean[][][] dp=new boolean[m][n][len+1];
        dp[0][0][grid[0][0]=='('?1:0]=true;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0) continue;
                int add=grid[i][j]=='('?1:-1;
                for(int b=0;b<=len;b++){
                    int prev=b-add;
                    if(prev<0||prev>len) continue;

                    if(i>0&&dp[i-1][j][prev])
                        dp[i][j][b]=true;

                    if(j>0&&dp[i][j-1][prev])
                        dp[i][j][b]=true;
                }
            }
        }
        return dp[m-1][n-1][0];
    }
}
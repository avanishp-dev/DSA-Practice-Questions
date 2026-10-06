class Solution {
    public int longIncPath(int[][] matrix,int n,int m) {
        int[][] in=new int[n][m];
        int[][] dp=new int[n][m];
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        ArrayDeque<Integer> q=new ArrayDeque<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=1;
                for(int d=0;d<4;d++){
                    int ni=i+dr[d],nj=j+dc[d];
                    if(ni>=0&&ni<n&&nj>=0&&nj<m&&matrix[ni][nj]<matrix[i][j])
                        in[i][j]++;
                }
                if(in[i][j]==0)
                    q.offer(i*m+j);
            }
        }

        int ans=1;
        while(!q.isEmpty()){
            int x=q.poll();
            int r=x/m,c=x%m;

            for(int d=0;d<4;d++){
                int nr=r+dr[d],nc=c+dc[d];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&matrix[nr][nc]>matrix[r][c]){
                    dp[nr][nc]=Math.max(dp[nr][nc],dp[r][c]+1);
                    in[nr][nc]--;
                    if(in[nr][nc]==0)
                        q.offer(nr*m+nc);
                }
            }
            ans=Math.max(ans,dp[r][c]);
        }
        return ans;
    }
}
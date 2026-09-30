class Solution {
    public int ways(int x,int y) {
        int mod=1000000007;
        long[] dp=new long[y+1];
        Arrays.fill(dp,1);

        for(int i=1;i<=x;i++){
            for(int j=1;j<=y;j++){
                dp[j]=(dp[j]+dp[j-1])%mod;
            }
        }

        return (int)dp[y];
    }
}
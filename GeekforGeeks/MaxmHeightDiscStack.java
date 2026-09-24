class Solution {
    public int maxStackHeight(int[] r,int[] h) {
        int n=r.length;
        int[][] d=new int[n][2];
        for(int i=0;i<n;i++){
            d[i][0]=r[i];
            d[i][1]=h[i];
        }
        Arrays.sort(d,(a,b)->a[0]!=b[0]?Integer.compare(a[0],b[0]):Integer.compare(a[1],b[1]));
        int[] bit=new int[1002];
        int ans=0,i=0;
        while(i<n){
            int j=i;
            while(j<n&&d[j][0]==d[i][0]) j++;
            int[] dp=new int[j-i];
            for(int k=i;k<j;k++){
                dp[k-i]=d[k][1]+query(bit,d[k][1]-1);
                ans=Math.max(ans,dp[k-i]);
            }
            for(int k=i;k<j;k++) update(bit,d[k][1],dp[k-i]);
            i=j;
        }
        return ans;
    }
    int query(int[] bit,int i){
        int max=0;
        while(i>0){
            max=Math.max(max,bit[i]);
            i-=i&-i;
        }
        return max;
    }
    void update(int[] bit,int i,int val){
        while(i<bit.length){
            bit[i]=Math.max(bit[i],val);
            i+=i&-i;
        }
    }
}
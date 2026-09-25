class Solution {
    public int maxHeight(int[] height,int[] width,int[] length) {
        int n=height.length;
        int[][] box=new int[3*n][3];
        int k=0;

        for(int i=0;i<n;i++){
            int a=height[i],b=width[i],c=length[i];
            box[k++]=new int[]{a,Math.max(b,c),Math.min(b,c)};
            box[k++]=new int[]{b,Math.max(a,c),Math.min(a,c)};
            box[k++]=new int[]{c,Math.max(a,b),Math.min(a,b)};
        }

        Arrays.sort(box,(a,b)->{
            if(a[1]!=b[1]) return Integer.compare(b[1],a[1]);
            return Integer.compare(b[2],a[2]);
        });

        int m=3*n;
        int[] dp=new int[m];
        int ans=0;

        for(int i=0;i<m;i++){
            dp[i]=box[i][0];

            for(int j=0;j<i;j++){
                if(box[j][1]>box[i][1]&&box[j][2]>box[i][2])
                    dp[i]=Math.max(dp[i],dp[j]+box[i][0]);
            }

            ans=Math.max(ans,dp[i]);
        }

        return ans;
    }
}
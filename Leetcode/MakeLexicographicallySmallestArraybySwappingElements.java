class Solution {
    public int[] lexicographicallySmallestArray(int[] nums,int limit) {
        int n=nums.length;
        int[][] a=new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0]=nums[i];
            a[i][1]=i;
        }
        Arrays.sort(a,(x,y)->Integer.compare(x[0],y[0]));
        int[] ans=new int[n];
        int start=0;
        while(start<n){
            int end=start;
            while(end+1<n && (long)a[end+1][0]-a[end][0]<=limit)
                end++;
            int[] idx=new int[end-start+1];
            for(int i=0;i<idx.length;i++)
                idx[i]=a[start+i][1];
            Arrays.sort(idx);
            for(int i=0;i<idx.length;i++)
                ans[idx[i]]=a[start+i][0];
            start=end+1;
        }
        return ans;
    }
}
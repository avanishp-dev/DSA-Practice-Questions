class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] freq=new int[100001];
        int max=0;
        for(int i=0;i<nums1.length;i++){
            int diff=Math.abs(nums1[i]-nums2[i]);
            freq[diff]++;
            max=Math.max(max,diff);
        }
        long k=(long)k1+k2;
        while(k>0&&max>0){
            if(freq[max]<=k){
                k-=freq[max];
                freq[max-1]+=freq[max];
                freq[max]=0;
                max--;
            }else{
                int use=(int)k;
                freq[max]-=use;
                freq[max-1]+=use;
                k=0;
            }
        }
        long ans=0;
        for(int i=1;i<freq.length;i++){
            ans+=(long)i*i*freq[i];
        }
        return ans;
    }
}
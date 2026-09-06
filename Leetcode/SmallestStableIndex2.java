
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] mn = new int[n];
        mn[n-1] = nums[n-1] ;
        for (int i = n-2; i >= 0; i--)
            mn[i] = Math.min(nums[i], mn[i+1]);
        int mxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mxi = Math.max(mxi, nums[i]) ;
            if (mxi - mn[i] <= k) return i;
        }
        return -1;
    }
}
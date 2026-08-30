class Solution {
    public int longestSubsequence(int[] nums) {
        int x =0;
        boolean ok=false;
        for(int i=0;i<nums.length;i++){
            x =x^nums[i];
            if(nums[i]!= 0)
                ok= true;
        }
        if(x!=0)
            return nums.length;
        if(ok)
            return nums.length - 1;
        return 0;
    }
}
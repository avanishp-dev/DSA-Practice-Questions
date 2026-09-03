class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = nums1[0];
        boolean allEven = true;
        for (int x : nums1) {
            min = Math.min(min, x);
            if ((x & 1) != 0) {
                allEven = false;
            }
        }
        return (min & 1) != 0 || allEven;
    }
}
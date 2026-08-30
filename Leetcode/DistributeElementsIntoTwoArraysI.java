class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] a = new int[n];
        int[] b = new int[n];
        int x = 0, y = 0;
        a[x++] = nums[0];
        b[y++] = nums[1];
        for (int i = 2; i < n; i++) {
            if (a[x - 1] > b[y - 1]) {
                a[x] = nums[i];
                x++;
            } else {
                b[y] = nums[i];
                y++;
            }
        }
        int[] ans = new int[n];
        int k = 0;
        for (int i = 0; i < x; i++) {
            ans[k++] = a[i];
        }
        for (int i = 0; i < y; i++) {
            ans[k++] = b[i];
        }
        return ans;
    }
}
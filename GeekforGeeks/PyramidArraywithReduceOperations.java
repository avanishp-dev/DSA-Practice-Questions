class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = Math.min(arr[i], left[i - 1] + 1);
        }

        right[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(arr[i], right[i + 1] + 1);
        }

        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            maxHeight = Math.max(maxHeight, Math.min(left[i], right[i]));
        }

        long total = 0;

        for (int x : arr) {
            total += x;
        }

        long pyramidSum = (long) maxHeight * maxHeight;

        return (int)(total - pyramidSum);
    }
}
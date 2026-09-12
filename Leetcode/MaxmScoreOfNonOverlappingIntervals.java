

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[3], b[3]);
        });
        long[][] dpW = new long[n + 1][5];
        int[][][] dpI = new int[n + 1][5][];
        for (int i = 0; i <= n; i++)
            for (int k = 0; k <= 4; k++)
                dpI[i][k] = new int[0];
        for (int i = n - 1; i >= 0; i--) {
            int t = arr[i][1], l = i + 1, r = n;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (arr[m][0] > t)
                    r = m;
                else
                    l = m + 1;
            }
            int nxt = l;
            for (int k = 1; k <= 4; k++) {
                long sW = dpW[i + 1][k];
                int[] sI = dpI[i + 1][k];
                long tW = arr[i][2] + dpW[nxt][k - 1];
                int[] pI = dpI[nxt][k - 1];
                int[] tI = new int[pI.length + 1];
                System.arraycopy(pI, 0, tI, 0, pI.length);
                tI[tI.length - 1] = arr[i][3];
                Arrays.sort(tI);
                if (tW > sW) {
                    dpW[i][k] = tW;
                    dpI[i][k] = tI;
                } else if (sW > tW) {
                    dpW[i][k] = sW;
                    dpI[i][k] = sI;
                } else {
                    if (isLess(tI, sI)) {
                        dpW[i][k] = tW;
                        dpI[i][k] = tI;
                    } else {
                        dpW[i][k] = sW;
                        dpI[i][k] = sI;
                    }
                }
            }
        }
        return dpI[0][4];
    }

    private boolean isLess(int[] a, int[] b) {
        for (int i = 0; i < Math.min(a.length, b.length); i++) {
            if (a[i] != b[i])
                return a[i] < b[i];
        }
        return a.length < b.length;
    }
}
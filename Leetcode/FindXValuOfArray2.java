class Solution {
    int[] p;
    int[][] c;
    int K;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        K = k;
        int n = nums.length;
        int q = queries.length;
        
        p = new int[4 * n];
        c = new int[4 * n][k];
        
        build(0, 0, n - 1, nums);
        
        int[] result = new int[q];
        for (int i = 0; i < q; i++) {
            update(0, 0, n - 1, queries[i][0], queries[i][1]);
            result[i] = query(0, 0, n - 1, queries[i][2], n - 1)[queries[i][3]];
        }
        
        return result;
    }

    private void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            p[node] = nums[l] % K;
            c[node][p[node]] = 1;
            return;
        }
        
        int mid = l + (r - l) / 2;
        int left = 2 * node + 1;
        int right = 2 * node + 2;
        
        build(left, l, mid, nums);
        build(right, mid + 1, r, nums);
        
        p[node] = (p[left] * p[right]) % K;
        for (int i = 0; i < K; i++) {
            c[node][i] = c[left][i];
        }
        for (int i = 0; i < K; i++) {
            if (c[right][i] > 0) {
                c[node][(p[left] * i) % K] += c[right][i];
            }
        }
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            p[node] = val % K;
            for (int i = 0; i < K; i++) {
                c[node][i] = 0;
            }
            c[node][p[node]] = 1;
            return;
        }
        
        int mid = l + (r - l) / 2;
        int left = 2 * node + 1;
        int right = 2 * node + 2;
        
        if (idx <= mid) {
            update(left, l, mid, idx, val);
        } else {
            update(right, mid + 1, r, idx, val);
        }
        
        p[node] = (p[left] * p[right]) % K;
        for (int i = 0; i < K; i++) {
            c[node][i] = c[left][i];
        }
        for (int i = 0; i < K; i++) {
            if (c[right][i] > 0) {
                c[node][(p[left] * i) % K] += c[right][i];
            }
        }
    }

    private int[] query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            int[] res = new int[K + 1];
            for (int i = 0; i < K; i++) {
                res[i] = c[node][i];
            }
            res[K] = p[node];
            return res;
        }
        
        int mid = l + (r - l) / 2;
        int left = 2 * node + 1;
        int right = 2 * node + 2;
        
        if (qr <= mid) {
            return query(left, l, mid, ql, qr);
        }
        if (ql > mid) {
            return query(right, mid + 1, r, ql, qr);
        }
        
        int[] resLeft = query(left, l, mid, ql, qr);
        int[] resRight = query(right, mid + 1, r, ql, qr);
        int[] res = new int[K + 1];
        
        for (int i = 0; i < K; i++) {
            res[i] = resLeft[i];
        }
        for (int i = 0; i < K; i++) {
            if (resRight[i] > 0) {
                res[(resLeft[K] * i) % K] += resRight[i];
            }
        }
        res[K] = (resLeft[K] * resRight[K]) % K;
        
        return res;
    }
}
class Solution {
    public boolean checkOverlap(int r, int x, int y, int x1, int y1, int x2, int y2) {
        int a = Math.max(x1, Math.min(x, x2)), b = Math.max(y1, Math.min(y, y2));
        return (x - a) * (x - a) + (y - b) * (y - b) <= r * r;
    }
}
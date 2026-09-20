class Solution {
    public int reverseDegree(String s) {
        int x = 0;
        for (int i = 0; i < s.length(); i++)
            x += (i + 1) * ('z' - s.charAt(i) + 1);
        return x;
    }
}
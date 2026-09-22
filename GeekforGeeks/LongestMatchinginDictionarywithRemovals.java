class Solution {
    public String findLongestWord(String s, List<String> d) {
        int n = s.length();
        int[][] next = new int[n + 1][26];

        for (int c = 0; c < 26; c++) {
            next[n][c] = n;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int c = 0; c < 26; c++) {
                next[i][c] = next[i + 1][c];
            }

            next[i][s.charAt(i) - 'a'] = i;
        }

        String ans = "";

        for (String word : d) {
            int pos = 0;
            boolean possible = true;

            for (int i = 0; i < word.length(); i++) {
                int p = next[pos][word.charAt(i) - 'a'];

                if (p == n) {
                    possible = false;
                    break;
                }

                pos = p + 1;
            }

            if (possible) {
                if (word.length() > ans.length() ||
                    (word.length() == ans.length() && word.compareTo(ans) < 0)) {
                    ans = word;
                }
            }
        }

        return ans;
    }
}
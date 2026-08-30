class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int half = n / 2;

        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        int odd = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1) {
                odd++;
                mid = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        int[] rem = new int[26];

        for (int i = 0; i < 26; i++) {
            rem[i] = cnt[i] / 2;
        }

        for (int i = 0; i < half; i++) {
            rem[target.charAt(i) - 'a']--;
        }

        int negative = 0;

        for (int x : rem) {
            if (x < 0) {
                negative++;
            }
        }

        if (negative == 0) {
            String left = target.substring(0, half);

            StringBuilder candidate = new StringBuilder();
            candidate.append(left);

            if ((n & 1) == 1) {
                candidate.append(mid);
            }

            candidate.append(new StringBuilder(left).reverse());

            String ans = candidate.toString();

            if (ans.compareTo(target) > 0) {
                return ans;
            }
        }

        for (int i = half - 1; i >= 0; i--) {
            int current = target.charAt(i) - 'a';

            rem[current]++;

            if (negative > 0) {
                negative = 0;

                for (int x : rem) {
                    if (x < 0) {
                        negative++;
                    }
                }
            }

            if (negative > 0) {
                continue;
            }

            int next = current + 1;

            while (next < 26 && rem[next] == 0) {
                next++;
            }

            if (next == 26) {
                continue;
            }

            rem[next]--;

            StringBuilder left = new StringBuilder();

            for (int j = 0; j < i; j++) {
                left.append(target.charAt(j));
            }

            left.append((char) ('a' + next));

            for (int j = 0; j < 26; j++) {
                while (rem[j] > 0) {
                    left.append((char) ('a' + j));
                    rem[j]--;
                }
            }

            StringBuilder ans = new StringBuilder();

            ans.append(left);

            if ((n & 1) == 1) {
                ans.append(mid);
            }

            ans.append(new StringBuilder(left).reverse());

            return ans.toString();
        }

        return "";
    }
}
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int len = words[0].length();
        int total = words.length;
        String[] unique = new String[total];
        int[] need = new int[total];
        int uniqueCount = 0;
        for (String word : words) {
            int index = -1;
            for (int i = 0; i < uniqueCount; i++) {
                if (unique[i].equals(word)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                unique[uniqueCount] = word;
                need[uniqueCount] = 1;
                uniqueCount++;
            } else {
                need[index]++;
            }
        }
        for (int offset = 0; offset < len; offset++) {
            int left = offset;
            int right = offset;
            int count = 0;
            int[] used = new int[uniqueCount];
            while (right + len <= n) {
                String word = s.substring(right, right + len);
                right += len;
                int index = -1;
                for (int i = 0; i < uniqueCount; i++) {
                    if (unique[i].equals(word)) {
                        index = i;
                        break;
                    }
                }
                if (index == -1) {
                    left = right;
                    count = 0;
                    used = new int[uniqueCount];
                    continue;
                }
                used[index]++;
                count++;
                while (used[index] > need[index]) {
                    String remove = s.substring(left, left + len);

                    for (int i = 0; i < uniqueCount; i++) {
                        if (unique[i].equals(remove)) {
                            used[i]--;
                            break;
                        }
                    }
                    left += len;
                    count--;
                }
                if (count == total) {
                    ans.add(left);

                    String remove = s.substring(left, left + len);

                    for (int i = 0; i < uniqueCount; i++) {
                        if (unique[i].equals(remove)) {
                            used[i]--;
                            break;
                        }
                    }
                    left += len;
                    count--;
                }
            }
        }
        return ans;
    }
}

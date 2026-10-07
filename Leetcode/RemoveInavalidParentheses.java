class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(s);
        visited.add(s);
        boolean found = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                String curr = q.poll();
                if (isValid(curr)) {
                    ans.add(curr);
                    found = true;
                }
                if (found) {
                    continue;
                }
                for (int i = 0; i < curr.length(); i++) {
                    if (curr.charAt(i) != '(' && curr.charAt(i) != ')') {
                        continue;
                    }
                    String next = curr.substring(0, i) + curr.substring(i + 1);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                }
            }
            if (found) {
                break;
            }
        }
        return ans;
    }
    private boolean isValid(String s) {
        int balance = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;

                if (balance < 0) {
                    return false;
                }
            }
        }
        return balance == 0;
    }
}
import java.util.*;
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        StringBuilder res = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean inBracket = false;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                inBracket = true;
                key.setLength(0);
            } else if (c == ')') {
                inBracket = false;
                res.append(map.getOrDefault(key.toString(), "?"));
            } else {
                if (inBracket) {
                    key.append(c);
                } else {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }
}
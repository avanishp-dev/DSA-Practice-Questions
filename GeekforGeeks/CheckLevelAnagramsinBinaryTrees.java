/* Structure of binary tree Node
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.add(root1);
        q2.add(root2);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int n1 = q1.size();
            int n2 = q2.size();
            if (n1 != n2)
                return false;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n1; i++) {
                Node node = q1.poll();
                map.put(node.data, map.getOrDefault(node.data, 0) + 1);
                if (node.left != null)
                    q1.add(node.left);
                if (node.right != null)
                    q1.add(node.right);
            }
            for (int i = 0; i < n2; i++) {
                Node node = q2.poll();
                if (!map.containsKey(node.data))
                    return false;
                map.put(node.data, map.get(node.data) - 1);
                if (map.get(node.data) == 0)
                    map.remove(node.data);
                if (node.left != null)
                    q2.add(node.left);
                if (node.right != null)
                    q2.add(node.right);
            }
            if (!map.isEmpty())
                return false;
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}

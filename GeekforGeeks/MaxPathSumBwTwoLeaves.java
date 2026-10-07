/* Node Structure
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    int ans;

    public int maxPathSum(Node root) {
        ans = Integer.MIN_VALUE;
        maxSum(root);

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    int maxSum(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        if (root.left == null && root.right == null) {
            return root.data;
        }

        if (root.left == null) {
            return root.data + maxSum(root.right);
        }

        if (root.right == null) {
            return root.data + maxSum(root.left);
        }

        int left = maxSum(root.left);
        int right = maxSum(root.right);

        ans = Math.max(ans, root.data + left + right);

        return root.data + Math.max(left, right);
    }
}
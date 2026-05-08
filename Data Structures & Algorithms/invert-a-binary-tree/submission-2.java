/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);
        while (!treeQueue.isEmpty()) {
            TreeNode node = treeQueue.poll();
            if (node == null) {
                continue;
            }
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = temp;
            treeQueue.add(node.right);
            treeQueue.add(node.left);
        }
        return root;
    }
}

package Test;

public class L226 {
    public TreeNode invertTree(TreeNode root) {
        reverseTree(root);
        return root;
    }

    private void reverseTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        reverseTree(root.left);
        reverseTree(root.right);
    }

}

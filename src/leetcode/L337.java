package Test;

import java.util.HashMap;
import java.util.Map;

public class L337 {
//    Map<TreeNode, Integer> choose = new HashMap<>();
//
//    Map<TreeNode, Integer> notChoose = new HashMap<>();
//
//    public int rob(TreeNode root) {
//        choose.put(null, 0);
//        notChoose.put(null, 0);
//        dfs(root);
//        return Math.max(choose.get(root), notChoose.get(root));
//    }
//
//    private void dfs(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        dfs(root.left);
//        dfs(root.right);
//        choose.put(root, root.val + notChoose.get(root.left) + notChoose.get(root.right));
//        notChoose.put(root, Math.max(choose.get(root.left), notChoose.get(root.left)) + Math.max(choose.get(root.right), notChoose.get(root.right)));
//    }

    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int choose = root.val + left[1] + right[1];
        int notChoose = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{choose, notChoose};
    }
}

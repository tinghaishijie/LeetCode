package leetcode;

import java.util.*;

public class L103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        boolean isReverse = false;
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> parts = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = stack.pop();
                parts.add(cur.val);
                if (cur.left != null) {
                    stack.add(cur.left);
                }
                if (cur.right != null) {
                    stack.add(cur.right);
                }
            }
            if (isReverse) {
                Collections.reverse(parts);
            }
            isReverse = !isReverse;
            ans.add(parts);
        }
        return ans;
    }
}

package leetcode;

public class L109 {
    private ListNode point;

    public TreeNode sortedListToBST(ListNode head) {
        point = head;
        int len = getLen(head);
        return buildTree(0, len - 1);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid-1);
        root.val = point.val;
        point = point.next;
        root.right = buildTree(mid+1, right);
        return root;
    }

    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}

package offer;

public class J33 {
    public boolean verifyPostorder(int[] postorder) {
        return isBST(postorder, 0, postorder.length - 1);
    }

    private boolean isBST(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = postorder[end];
        int rightStart = end;
        boolean isStartRight = false;
        for (int i = start; i < end; i++) {
            if (isStartRight) {
                if (postorder[i] < root) {
                    return false;
                }
            }
            if (postorder[i] > root) {
                rightStart = i;
                isStartRight = true;
            }
        }
        boolean isLeft = isBST(postorder, start, rightStart - 1);
        boolean isRight = isBST(postorder, rightStart, end - 1);
        return isLeft && isRight;
    }
}

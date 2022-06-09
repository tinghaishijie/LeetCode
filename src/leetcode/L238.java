package Test;

public class L238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        result[0] = 1;
        int right = 1;
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right *= nums[i + 1];
            result[i] = result[i] * right;
        }
        return result;
    }
}

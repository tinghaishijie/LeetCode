package Test;

import java.util.HashMap;
import java.util.Map;

public class L560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> pres = new HashMap<>();
        pres.put(0, 1); // 从头开始
        int pre = 0;
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            pre += nums[i];
            if (pres.containsKey(pre - k)) {
                count += pres.get(pre - k);
            }
            pres.put(pre, pres.getOrDefault(pre, 0) + 1);
        }

        return count;
    }
}

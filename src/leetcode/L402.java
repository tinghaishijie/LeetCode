package Test;

import java.util.Deque;
import java.util.LinkedList;

public class L402 {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len == k) return "0";
        char[] chars = num.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (chars[i] == '0' && stack.isEmpty()) {
                continue;
            }
            stack.push(chars[i]);
            while (k > 0 && !stack.isEmpty()) {
                k--;
                stack.pop();
                if (i == len - 1) {
                    continue;
                }
                Character cur = stack.peek();
                if (cur <= chars[i + 1]) {
                    break;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pollLast());
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }
}

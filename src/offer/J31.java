package Test;

import java.util.Deque;
import java.util.LinkedList;

public class J31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int pushIndex = 0;
        for (int i = 0; i < popped.length; i++) {
            while (stack.isEmpty() || stack.peek() != popped[i]) {
                if (pushIndex >= pushed.length) {
                    break;
                }
                stack.push(pushed[pushIndex]);
                pushIndex++;
            }
            if (stack.peek() == popped[i]) {
                stack.pop();
                continue;
            }
            if (pushIndex >= pushed.length) {
                return false;
            }
        }
        return true;
    }
}

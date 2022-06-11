package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L207 {
    private List<List<Integer>> depends = new ArrayList<>();

    private int[] status;

    private boolean canReach = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        status = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            depends.add(new ArrayList<>());
        }
        for (int[] depend : prerequisites) {
            depends.get(depend[0]).add(depend[1]);
        }
        for (int i = 0; i < numCourses && canReach; i++) {
            if (status[i] == 0) {
                dfs(i);
            }
        }

        return canReach;
    }

    private void dfs(int course) {
        status[course] = 1;
        for (int pre : depends.get(course)) {
            if (!canReach) {
                return;
            }
            if (status[pre] == 1) {
                canReach = false;
                return;
            }
            if (status[pre] == 0) {
                dfs(pre);
            }
        }
        status[course] = 2;
    }
}

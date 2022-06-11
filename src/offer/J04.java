package offer;

public class J04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int xLen = matrix.length;
        if (xLen == 0) {
            return false;
        }
        int yLen = matrix[0].length;
        if (yLen == 0) {
            return false;
        }
        int startX = 0;
        int startY = yLen - 1;
        while (startX < xLen && startY >= 0) {
            if (matrix[startX][startY] == target) {
                return true;
            } else if (matrix[startX][startY] > target) {
                startY--;
            } else {
                startX++;
            }
        }
        return false;
    }
}

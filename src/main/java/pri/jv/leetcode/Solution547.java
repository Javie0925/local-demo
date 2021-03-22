package pri.jv.leetcode;

/**
 * @ClassName Solution547
 * @Dscription
 * @Date 3/22/21
 * @Author JV
 **/
public class Solution547 {

    private boolean[][] isIterated;

    public int findCircleNum(int[][] isConnected) {
        isIterated = new boolean[isConnected.length][isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            isIterated[i][i] = true;
            if (isConnected[i][i] == 1) {
                count++;
                iterateY(isConnected, i, i);
            }
        }
        return count;
    }

    private void iterateX(int[][] isConnected, int y, int x) {
        for (int i=x; i <= y; i++) {

            if (isConnected[i][y] == 1) {
                isConnected[i][y] = 0;
                iterateX(isConnected, i, y);
                iterateY(isConnected, i, y);
            }
            isIterated[x][i] = true;
        }
        for (int i=x; i >=0; i--) {

            if (isConnected[i][y] == 1) {
                isConnected[i][y] = 0;
                iterateX(isConnected, i, y);
                iterateY(isConnected, i, y);
            }
            isIterated[x][i] = true;
        }
    }

    private void iterateY(int[][] isConnected, int y, int x) {
        for (int i = y; i < isConnected.length; i++) {
            if (isIterated[x][i] && isConnected[x][i] == 1) {
                isConnected[x][i] = 0;
                iterateX(isConnected, x, i);
                iterateY(isConnected, x, i);
            }
            isIterated[x][i] = true;
        }
        for (int i=y; i >= x; i--) {
            if (isIterated[x][i] && isConnected[x][i] == 1) {
                isConnected[x][i] = 0;
                iterateX(isConnected, x, i);
                iterateY(isConnected, x, i);
            }
            isIterated[x][i] = true;
        }
    }

    public static void main(String[] args) {
        Solution547 solution547 = new Solution547();
        int[][] ints = {{1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}};
        int circleNum = solution547.findCircleNum(ints);
        System.out.println(circleNum);
    }
}

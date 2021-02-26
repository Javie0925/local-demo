package pri.jv.leetcode;

/**
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
 * 每个细胞都具有一个初始状态：1 即为活细胞（live），
 * 或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * 给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 * <p>
 * 一、原地算法简介
 * 在计算机科学中，一个原地算法（in-place algorithm）基本上不需要额外辅助的数据结构,
 * 然而,允许少量额外的辅助变量来转换数据的算法。当算法运行时，输入的数据通常会被要输出的部分覆盖掉。
 * 不是原地算法有时候称为非原地（not-in-place）或不得其所（out-of-place）。–摘自维基百科。
 * 在计算复杂性理论中，原地算法包含使用O(1)空间复杂度的所有算法，DSPACE(1)类型。
 * <p>
 * [i-1][j-1]   [i-1][j]   [i-1][j+1]
 * <p>
 * [i][j-1]      [i][j]     [i][j+1]
 * <p>
 * [i+1][j-1]   [i+1][j]   [i+1][j+1]
 * <p>
 * 进阶：
 * <p>
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，
 * 然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。
 * 你将如何解决这些问题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution289 {

    /**
     * 复合状态：
     * -1，上回是活的这次死了
     * 2，上回活的，这会还是活的
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        if (board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int sum = getVal(board, i - 1, j - 1)
                        + getVal(board, i - 1, j)
                        + getVal(board, i - 1, j + 1)
                        + getVal(board, i, j - 1)
                        + getVal(board, i, j + 1)
                        + getVal(board, i + 1, j - 1)
                        + getVal(board, i + 1, j)
                        + getVal(board, i + 1, j + 1);

                if (board[i][j] == 0) {
                    if (sum == 3) {
                        board[i][j] = 2;
                    }
                } else if (board[i][j] == 1) {
                    if (sum == 2 || sum == 3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
            System.out.println();
        }
    }

//    public void gameOfLife(int[][] board) {
//        if (board.length==0){
//            return;
//        }
//        int[][] result = new int[board.length][board[0].length];
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                int sum = getVal(board, i - 1, j - 1)
//                        + getVal(board, i - 1, j)
//                        + getVal(board, i - 1, j + 1)
//                        + getVal(board, i, j - 1)
//                        + getVal(board, i, j + 1)
//                        + getVal(board, i + 1, j - 1)
//                        + getVal(board, i + 1, j)
//                        + getVal(board, i + 1, j + 1);
//
//                if (board[i][j] == 0) {
//                    if (sum == 3) {
//                        result[i][j] = 1;
//                    } else {
//                        result[i][j] = 0;
//                    }
//                } else if (board[i][j] == 1) {
//                    if (sum == 2 || sum == 3) {
//                        result[i][j] = 1;
//                    } else {
//                        result[i][j] = 0;
//                    }
//                }
//            }
//        }
//        for (int i=0;i<result.length;i++){
//            for (int j=0;j<result[0].length;j++){
//                board[i][j] = result[i][j];
//            }
//        }
//    }

    public int getVal(int[][] board, int i, int j) {
        try {
            int val = board[i][j];
            if (val == -1) {
                return 1;
            }
            if (val == 2) {
                return 0;
            }
            return val;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution289 solution289 = new Solution289();
        int[][] arr = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------");
        solution289.gameOfLife(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

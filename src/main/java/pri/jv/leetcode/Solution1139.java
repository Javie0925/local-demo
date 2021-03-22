package pri.jv.leetcode;

/**
 * @ClassName Solution1139
 * @Dscription
 * @Date 3/10/21
 * @Author JV
 **/
public class Solution1139 {
    public int largest1BorderedSquare(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] dp1 = new int[grid.length][grid[0].length];
        int[][] dp2 = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int maxLen1 = 1;
                    int maxLen2 = 1;
                    for (int n = i + 1, m = j + 1; n < grid.length && m < grid[0].length; n++, m++) {
                        if (grid[i][m] == 1 && grid[n][j] == 1) {
                            maxLen1++;
                        } else {
                            break;
                        }
                    }
                    for (int n = i - 1, m = j - 1; n >= 0 && m >= -0; n--, m--) {
                        if (grid[i][m] == 1 && grid[n][j] == 1) {
                            maxLen2++;
                        } else {
                            break;
                        }
                    }
                    dp1[i][j] = maxLen1;
                    dp2[i][j] = maxLen2;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int len1 = dp1[i][j];
                if (len1 >= 1) {
                    for (int n = i + len1 - 1, m = j + len1 - 1; n >= i && m >= j; n--, m--,len1--) {
                        if (n >= grid.length || m >= grid[0].length) {
                            continue;
                        }
                        int len2 = dp2[n][m];
                        if (len1 <= len2) {
                            result = Math.max((n - i + 1) * (n - i + 1), result);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1139 solution1139 = new Solution1139();
        int[][] grid = {{1, 0, 1, 0, 1, 1}, {1, 1, 0, 1, 0, 1}, {0, 1, 1, 1, 1, 1}, {0, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1}, {1, 0, 0, 1, 0, 0}, {0, 1, 1, 0, 1, 1}};
        System.out.println(solution1139.largest1BorderedSquare(grid));
    }
}

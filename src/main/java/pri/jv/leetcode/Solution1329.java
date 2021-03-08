package pri.jv.leetcode;

/**
 * @ClassName Solution1329
 * @Dscription
 * @Date 3/2/21
 * @Author JV
 **/
class Solution1329 {
    public int[][] diagonalSort(int[][] mat) {
        for (int i = mat.length - 2, j = 0;i>=0; i--) {
            for (int n = i, m = j; n < mat.length && m < mat[0].length; n++, m++) {
                int minN = n;
                int minM = m;
                for (int x=i+1,y=m+1;x < mat.length && y < mat[0].length;x++,y++){
                    if (mat[x][y]<mat[minN][minM]){
                        minN = x;
                        minM = y;
                    }
                }
                int temp = mat[minN][minM];
                mat[minN][minM] = mat[n][m];
                mat[n][m] = temp;
            }
        }
        for (int i = 0, j = 1;j<mat[0].length; j++) {
            for (int n = i, m = j; n < mat.length && m < mat[0].length; n++, m++) {
                int minN = n;
                int minm = m;
                for (int x=i+1,y=m+1;x <mat.length && y < mat[0].length;x++,y++){
                    if (mat[x][y]<mat[minN][minm]){
                        minN = x;
                        minm = y;
                    }
                }
                int temp = mat[minN][minm];
                mat[minN][minm] = mat[n][m];
                mat[n][m] = temp;
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] ints = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        Solution1329 solution = new Solution1329();
        solution.diagonalSort(ints);
    }
}

class Solution {
    public int[][] transpose(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        int[][] ans = new int[C][R];

        for(int r=0;r<C;r++) {
            for(int c=0;c<R;c++) {
                ans[r][c] = matrix[c][r];
            }
        }
        return ans;
    }
}
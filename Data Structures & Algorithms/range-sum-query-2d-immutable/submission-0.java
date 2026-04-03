class NumMatrix {
    int [][] nums;

    public NumMatrix(int[][] matrix) {
        this.nums = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if ( i <= row2 && i >= row1 && j <= col2 && j >= col1) {
                    res += nums[i][j];
                }
            }
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
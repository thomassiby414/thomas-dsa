class Solution {
    public void setZeroes(int[][] matrix) {
        // brute force (only works if matrix doesnt contain -ve values)
        // for(int i=0; i<matrix.length; i++) {
        //     for(int j=0; j<matrix[i].length; j++) {
        //         if(matrix[i][j] == 0) {
        //             markRow(matrix,i);
        //             markCol(matrix,j);
        //         }
        //     }
        // }

        // for(int i=0; i<matrix.length; i++) {
        //     for(int j=0; j<matrix[i].length; j++) {
        //         if(matrix[i][j] == -1) {
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }
        // time = O(mn) + O(mn) = O(mn)
        // space = O(1)

        // better
        // int m=matrix.length, n=matrix[0].length;
        // int rows[] = new int[m];
        // int cols[] = new int[n];
        // for(int i=0; i<m; i++) {
        //     for(int j=0; j<n; j++) {
        //         if(matrix[i][j] == 0) {
        //             rows[i] = 1;
        //             cols[j] = 1;
        //         }
        //     }
        // }
        // for(int i=0; i<m; i++) {
        //     for(int j=0; j<n; j++) {
        //         if(rows[i]==1 || cols[j]==1) {
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }
        // time = O(mn) +O(mn) = O(mn)
        // space = O(m+n)

        // optimal
        // rows = matrix[......][0]
        // cols = matrix[0][.......]
        int m=matrix.length, n=matrix[0].length;
        int num00 = 1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if(j == 0) {
                        num00 = 0;
                    } else {
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0) {
            for(int i=0; i<n; i++) {
                matrix[0][i] = 0;
            }
        }
        if(num00 == 0) {
            for(int i=0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }
        // time = O(mn)
        // space = O(1)

        
        
    }

    void markRow(int[][] matrix, int row) {
        for(int i=0;  i<matrix[row].length; i++) {
            if(matrix[row][i] != 0) {
                matrix[row][i] = -1;
            }
        }
    }

    void markCol(int[][] matrix, int col) {
        for(int i=0;  i<matrix.length; i++) {
            if(matrix[i][col] != 0) {
                matrix[i][col] = -1;
            }
        }
    }

}
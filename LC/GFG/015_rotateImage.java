class Solution {
    public void rotate(int[][] matrix) {
        // brute force
        // int n = matrix.length;
        // int temp[][] = new int[n][n];
        // for(int i=0; i<n; i++) {
        //     for(int j=0; j<n; j++) {
        //         temp[i][j] = matrix[n-1-j][i];
        //     }
        // }
        // for(int i=0; i<n; i++) {
        //     for(int j=0; j<n; j++) {
        //         matrix[i][j] = temp[i][j];
        //     }
        // } 
        // time = O(n^2)+O(n^2) = O(n^2)
        // space = O(n^2)

        // optimal (transpose and reverse)
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0; i<n; i++) {
            reverseRow(matrix, i);
        }
        // time = O(n^2)
        // space = O(1)
        
    }

    void reverseRow(int[][] matrix, int row) {
        int start=0, end=matrix.length-1;
        while(start < end) {
            int temp = matrix[row][start];
            matrix[row][start] = matrix[row][end];
            matrix[row][end] = temp;
            start++;
            end--;
        }
    }


}
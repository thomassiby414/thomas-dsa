class Solution {
    public int[] findPeakGrid(int[][] mat) {
        // brute force
        // int m=mat.length, n=mat[0].length;
        // for(int i=0; i<m; i++) {
        //     for(int j=0; j<n; j++) {
        //         int num = mat[i][j];
        //         int left = (j-1 >= 0) ? mat[i][j-1] : -1;
        //         int right = (j+1 < n) ? mat[i][j+1] : -1;
        //         int top = (i-1 >= 0) ? mat[i-1][j] : -1;
        //         int bottom = (i+1 < m) ? mat[i+1][j] : -1;
        //         if(num>left && num>right && num>top && num>bottom) {
        //             return new int[]{i, j};
        //         }
        //     }
        // }
        // return new int[]{-1, -1};
        // time = O(m*n)

        // optimal
        int m=mat.length, n=mat[0].length;
        int start=0, end=m-1;
        while(start <= end) {
            int row = (start+end)/2;
            int col = getMaxColIndex(mat[row]);
            int num = mat[row][col];
            int top = (row-1 >= 0) ? mat[row-1][col] : -1;
            int bottom = (row+1 < m) ? mat[row+1][col] : -1;
            if(num>top && num>bottom) {
                return new int[]{row, col};
            } else if(num < bottom) {
                start = row+1;
            } else {
                end = row-1;
            }
        }
        return new int[]{-1, -1};
        // time = O(n * logm)
    }

    int getMaxColIndex(int arr[]) {
        int col=-1, max=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                col = i;
            }
        }
        return col;
    }
}
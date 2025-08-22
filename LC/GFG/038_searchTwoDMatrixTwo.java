class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // brute force
        // int m=matrix.length, n=matrix[0].length;
        // for(int i=0; i<m; i++) {
        //     for(int j=0; j<n; j++) {
        //         if(matrix[i][j] == target) {
        //             return true;
        //         }
        //     }
        // }
        // return false;
        // time = O(m*n)

        // better
        // int m=matrix.length, n=matrix[0].length;
        // for(int i=0; i<m; i++) {
        //     if(binarySearch(matrix[i], n, target)) {
        //         return true;
        //     }
        // }
        // return false;
        // time = O(m*logn)

        // optimal
        int m=matrix.length, n=matrix[0].length;
        int row=0, col=n-1;
        while(row<m && col>=0) {
            if(matrix[row][col] == target) {
                return true;
            }
            if(matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
        // time = O(m+n)
    }

    boolean binarySearch(int arr[], int n, int target) {
        int start=0, end=n-1;
        while(start <= end) {
            int mid = (start+end)/2;
            if(arr[mid] == target) {
                return true;
            } else if(arr[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return false;
    }
}
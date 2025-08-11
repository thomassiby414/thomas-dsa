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
        // space = O(1)

        // better (binary search)
        // int m=matrix.length, n=matrix[0].length;
        // for(int i=0; i<m; i++) {
        //     if(target>=matrix[i][0] && target<=matrix[i][n-1]) {
        //         return binarySearch(matrix[i], target);
        //     }
        // }
        // return false;
        // time = O(m*logn)
        // space = O(1)  

        // optimal
        int m=matrix.length, n=matrix[0].length;
        int start=0, end=m*n-1;
        while(start <= end) {
            int mid = (start+end)/2;
            int row=mid/n, col=mid%n;
            if(matrix[row][col] == target) {
                return true;
            }
            if(matrix[row][col] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }   
        return false;
        // time = O(log(m*n))
        // space = O(1)
    }

    boolean binarySearch(int row[], int target) {
        int start=0, end=row.length-1;
        while(start <= end) {
            int mid = (start+end)/2;
            if(row[mid] == target) {
                return true;
            }
            if(row[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return false;
    }
}
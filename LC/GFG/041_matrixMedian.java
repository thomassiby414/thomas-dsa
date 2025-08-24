class Solution {
    public int median(int[][] mat) {
        // brute force
        // List<Integer> temp = new ArrayList<>();
        // int m=mat.length, n=mat[0].length;
        // for(int i=0; i<m; i++) {
        //     for(int j=0; j<n; j++) {
        //         temp.add(mat[i][j]);
        //     }
        // }
        // Collections.sort(temp);
        // int mid = (m*n)/2;
        // return temp.get(mid);
        // time = O(m*n) + O((m*n)log(m*n))
        // space = O(m*n)
        
        // optimal
        int m=mat.length, n=mat[0].length;
        int start=Integer.MAX_VALUE, end=Integer.MIN_VALUE;
        for(int i=0; i<m; i++) {
            start = Math.min(start, mat[i][0]);
            end = Math.max(end, mat[i][n-1]);
        }
        int req = (m*n)/2;
        while(start <= end) {
            int mid = (start+end)/2;
            int count = findNoOfSmallerEquals(mat, mid);
            if(count <= req) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return start;
        // time = O(m) + O(mlognlog(max-min))
    }
    
    int findNoOfSmallerEquals(int mat[][], int x) {
        int count = 0;
        int m=mat.length, n=mat[0].length;
        for(int i=0; i<m; i++) {
            count += upperBound(mat[i], x);
        }
        return count;
    }
    
    int upperBound(int mat[], int x) {
        int start=0, end=mat.length-1;
        while(start <= end) {
            int mid = (start+end)/2;
            if(mat[mid] <= x) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return start;
    }
}
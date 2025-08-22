class Solution {
    public int rowWithMax1s(int arr[][]) {
        // brute force
        // int row=-1, maxCount=0;
        // int m=arr.length, n=arr[0].length;
        // for(int i=0; i<m; i++) {
        //     int count = 0;
        //     for(int j=0; j<n; j++) {
        //         // if(arr[i][j] == 1) {
        //         //     count++;
        //         // }
        //         count += arr[i][j];
        //     }
        //     if(count > maxCount) {
        //         maxCount = count;
        //         row = i;
        //     }
        // }
        // return row;
        // time = O(m*n)
        // space = O(1)
        
        // better (binary search)
        // int row=-1, maxCount=0;
        // int m=arr.length, n=arr[0].length;
        // for(int i=0; i<m; i++) {
        //     int count = n-lowerBound(arr[i], n);
        //     if(count > maxCount) {
        //         maxCount = count;
        //         row = i;
        //     }
        // }
        // return row;
        // time = O(m * logn)
        // space = O(1)
        
        // optimal (stair case)
        int m=arr.length, n=arr[0].length;
        int i=0, j=n-1;
	    int ans = -1;
	    while(i<m && j>=0) {
	        if(arr[i][j] == 1) {
	            ans = i;
	            j--;
	        } else {
	            i++;
	        }
	    }
	    return ans;
	   // time = O(m+n)
    }
    
    int lowerBound(int arr[], int n) {
       int ans = n;
       int start=0, end=n-1;
       while(start <= end) {
           int mid = (start+end)/2;
           if(arr[mid] == 1) {
               ans = mid;
               end = mid-1;
           } else {
               start = mid+1;
           }
       }
       return ans;
    }
}
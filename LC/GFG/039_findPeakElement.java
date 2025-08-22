class Solution {
    public int findPeakElement(int[] nums) {
        // brute force
        // int n = nums.length;
        // if(n == 1) return 0;
        // if(nums[0] > nums[1]) return 0;
        // if(nums[n-1] > nums[n-2]) return n-1;
        // for(int i=1; i<n-1; i++) {
        //     if(nums[i]>nums[i-1] && nums[i]>nums[i+1]) {
        //         return i;
        //     }
        // }
        // return -1;
        // time = O(n)
        // space = O(1)

        // optimal (binary)
        int n = nums.length;
        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;
        int start=1, end=n-2;
        while(start <= end) {
            int mid = (start+end)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) {
                return mid;
            }
            if(nums[mid] < nums[mid+1]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
        // time = O(logn)
        // space = O(1)
    }
}
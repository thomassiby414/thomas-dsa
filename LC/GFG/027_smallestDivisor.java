class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        // brute force
        // if(nums.length > threshold) return -1;
        // int max = findMax(nums);
        // for(int i=1; i<=max; i++) {
        //     int sum = 0;
        //     for(int num: nums) {
        //         sum += Math.ceil((double)num/(double)i);
        //     }
        //     if(sum <= threshold) return i;
        // }
        // return -1;
        // time = O(m*n) where m is maximum number
        // space = O(1)

        // better
        int ans = -1;
        if(nums.length > threshold) return ans;
        int max = findMax(nums);
        int start=1, end=max;
        while(start <= end) {
            int divisor = (start+end)/2;
            int sum = findSumOfDivisor(nums,divisor);
            if(sum <= threshold) {
                ans = divisor;
                end = divisor-1;
            } else {
                start = divisor+1;
            }
        }
        return ans;
        // time = O(nlogm), where m is the max(nums)
        // space = O(1)
    }

    int findSumOfDivisor(int nums[], int divisor) {
        int sum = 0;
        for(int num: nums) {
            // sum += Math.ceil((double)num/(double)divisor);
            sum += (num + divisor - 1) / divisor;
        }
        return sum;
    }

    int findMax(int nums[]) {
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            max = Math.max(max,num);
        }
        return max;
    }
}
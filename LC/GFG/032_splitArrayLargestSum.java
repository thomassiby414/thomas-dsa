class Solution {
    public int splitArray(int[] nums, int k) {
        // brute force
        // int minSum=Integer.MIN_VALUE, maxSum=0;
        // for(int num: nums) {
        //     minSum = Math.max(minSum, num);
        //     maxSum += num;
        // }
        // for(int sum=minSum; sum<=maxSum; sum++) {
        //     if(isSumPossible(nums, sum, k)) {
        //         return sum;
        //     }
        // }
        // return -1;
        // time = O(n)+O(nm) = O(nm) where m = sum(nums)-max(nums)
        // space = O(1)

        // optimal
        int ans = -1;
        int minSum=Integer.MIN_VALUE, maxSum=0;
        for(int num: nums) {
            minSum = Math.max(minSum, num);
            maxSum += num;
        }
        int start=minSum, end=maxSum;
        while(start <= end) {
            int sum = (start+end)/2;
            if(isSumPossible(nums, sum, k)) {
                ans = sum;
                end = sum-1;
            } else {
                start = sum+1;
            }
        }
        return ans;
        // time = O(n)+O(nlogm) = O(nlogm) where m=sum(nums)-max(nums)
        // space = O(1)
    }

    boolean isSumPossible(int nums[], int sum, int k) {
        int totalSum=0, countSubArray=1;
        for(int num: nums) {
            totalSum += num;
            if(totalSum > sum) {
                countSubArray++;
                totalSum = num;
            }
        }
        if(countSubArray <= k) return true;
        return false;
    }
}
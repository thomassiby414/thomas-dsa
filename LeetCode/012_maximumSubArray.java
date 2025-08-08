class Solution {
    public int maxSubArray(int[] nums) {
        // brute force
        // int max = Integer.MIN_VALUE;
        // for(int i=0; i<nums.length; i++) {
        //     int sum = 0;
        //     for(int j=i; j<nums.length; j++) {
        //         sum += nums[j];
        //         max = Math.max(max,sum);
        //     }
        // }
        // return max;
        // time = O(n^2)
        // space = O(1)

        // optimal (kadane's algorithm)
        int max=Integer.MIN_VALUE, sum=0;
        for(int i=0; i<nums.length; i++) {
            sum = Math.max(nums[i],sum+nums[i]);
            max = Math.max(max,sum);
        }
        return max;
        // time = O(n)
        // space = O(1)
        
    }
}
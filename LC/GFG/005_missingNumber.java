class Solution {
    public int missingNumber(int[] nums) {
        // brute force
        // for(int i=0; i<nums.length; i++) {
        //     boolean seen = false;
        //     for(int j=0; j<nums.length; j++) {
        //         if(i == nums[j]) {
        //             seen = true;
        //             break;
        //         }
        //     }
        //     if(!seen) {
        //         return i;
        //     }
        // }
        // return nums.length;
        // time = O(n^2)
        // space = O(1)
        
        // better
        // int seen[] = new int[nums.length+1];
        // for(int num: nums) {
        //     seen[num]++;
        // }
        // for(int i=0; i<seen.length; i++) {
        //     if(seen[i] == 0) {
        //         return i;
        //     }
        // }
        // return -1;
        // time = O(n) + O(n) = O(n)
        // space = O(n)

        // optimal (sum method)
        // int n = nums.length;
        // int summation = (n*(n+1))/2;
        // int sum = 0;
        // for(int num: nums) {
        //     sum += num;
        // }
        // return summation-sum;
        // time = O(n)
        // space = O(1)

        // optimal (xor method)
        int xor = 0;
        for(int i=0; i<nums.length; i++) {
            xor ^= i^nums[i];
        }
        return xor^nums.length;
        // time = O(n)
        // space = O(1)
    }
}
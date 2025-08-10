class Solution {
    public int findDuplicate(int[] nums) {
        // brute force
        // for(int i=0; i<nums.length; i++) {
        //     int count = 0;
        //     for(int j=i; j<nums.length; j++) {
        //         if(nums[i] == nums[j]) {
        //             count++;
        //             if(count > 1) {
        //                 return nums[i];
        //             }
        //         }
        //     }
        // }
        // return -1;
        // time = O(n^2)
        // space = O(1)

        // brute force 2
        // Arrays.sort(nums);
        // for(int i=0; i<nums.length-1; i++) {
        //     if(nums[i] == nums[i+1]) {
        //         return nums[i];
        //     }
        // }
        // return -1;
        // time = O(nlogn)+O(n) 
        // space = O(1)

        // better
        // int count[] = new int[nums.length+1];
        // for(int num: nums) {
        //     count[num]++;
        // }
        // for(int i=0; i<count.length; i++) {
        //     if(count[i] > 1) {
        //         return i;
        //     }
        // }
        // return -1;
        // time = O(n)+O(n) = O(n)
        // space = O(n)

        // optimal (floyd's cycle detection)
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        fast = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
        // time = O(n)
        // space = O(1)
        
    }
}
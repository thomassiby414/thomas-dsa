class Solution {
    public int majorityElement(int[] nums) {
        // brute force
        // for(int i=0; i<nums.length; i++) {
        //     int count = 0;
        //     for(int j=0; j<nums.length; j++) {
        //         if(nums[i] == nums[j]) {
        //             count++;
        //         }
        //     }
        //     if(count > nums.length/2) return nums[i];
        // }
        // return -1;
        // time = O(n^2)
        // space = O(1)

        // better
        // Map<Integer,Integer> map = new HashMap<>();
        // for(int num: nums) {
        //     map.put(num, map.getOrDefault(num,0)+1);
        //     if(map.getOrDefault(num,0) > nums.length/2) return num;
        // }
        // return -1;
        // time = O(n)
        // space = O(n)

        // optimal (Boyer–Moore Majority Vote Algorithm)
        int count=1, element=nums[0];
        for(int i=1; i<nums.length; i++) {
            if(count == 0) element = nums[i];
            if(nums[i] == element) count++;
            else count--;
        }
        count = 0;
        for(int num: nums) {
            if(num == element) count++;
            if(count > nums.length/2) return element;
        }
        return -1;
        // time = O(n)+O(n) = O(n)
        // space = O(1)
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        // brute force
        // if(nums.length == 0) return 0;
        // int max = 1;
        // for(int i=0; i<nums.length; i++) {
        //     int count = 1;
        //     int element = nums[i]+1;
        //     while(findElement(nums, element)) {
        //         count++;
        //         element++;
        //     }
        //     max = Math.max(max, count);
        // }
        // return max;
        // time = O(n^2)
        // space = O(1)

        // better
        // if(nums.length == 0) return 0;
        // Arrays.sort(nums);
        // int max = 1, count = 1;
        // for(int i=1; i<nums.length; i++) {
        //     if(nums[i] == nums[i-1]+1) {
        //         count++;
        //     } else if(nums[i] != nums[i-1]) {
        //         count = 1;
        //     }
        //     max = Math.max(max, count);
        // }
        // return max;
        // time = O(nlogn) + O(n) = O(nlogn)
        // space = O(1)

        // optimal
        if(nums.length == 0) return 0;
        int max = 1;
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        for(int num: set) {
            if(!set.contains(num-1)) {
                int count = 1;
                int curr = num;
                while(set.contains(curr+1)) {
                    count++;
                    curr++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
        // time = O(n) + O(n) = O(n)
        // space = O(n)
    }

    boolean findElement(int nums[], int target) {
        for(int num: nums) {
            if(target == num) return true;
        }
        return false;
    }
}
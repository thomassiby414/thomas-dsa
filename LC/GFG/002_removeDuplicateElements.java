class Solution {
    public int removeDuplicates(int[] nums) {
        // brute force
        // Set<Integer>set = new LinkedHashSet<>();
        // for(int num: nums) {
        //     if(!set.contains(num)) {
        //         set.add(num);
        //     }
        // }
        // int index=0;
        // for(int num: set) {
        //     nums[index++] = num;
        // }
        // return set.size();
        // time = O(n) + O(n) = O(n)
        // space = O(n)

        // optimal
        int index = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index+1;
        // time = O(n)
        // space = O(1)
    }
}
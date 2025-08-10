class Solution {
    public void moveZeroes(int[] nums) {
        // brute force
        // List<Integer>temp = new ArrayList<>();
        // for(int num: nums) {
        //     if(num != 0) {
        //         temp.add(num);
        //     }
        // }
        // for(int i=0; i<nums.length; i++) {
        //     if(i < temp.size()) {
        //         nums[i] = temp.get(i);
        //     } else {
        //         nums[i] = 0;
        //     }
        // }
        // time = O(n) + O(n) = O(n)
        // space = O(n)

        // optimal
        int j = -1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                j = i;
                break;
            }
        }
        if(j == -1) return;
        for(int i=j+1; i<nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        // time = O(n) + O(n) = O(n)
        // space = O(1)
        
    }
}
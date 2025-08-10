class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            reverse(nums,0,nums.length-1);
            return;
        }
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }
        reverse(nums,index+1,nums.length-1); 
        // time = O(n)+O(n)+O(n) = O(n)
        // space = O(1)
    }

    void reverse(int nums[], int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
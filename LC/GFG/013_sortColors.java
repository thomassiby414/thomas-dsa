class Solution {
    public void sortColors(int[] nums) {
        // brute force
        // List<Integer> zeros = new ArrayList<>();
        // List<Integer> ones = new ArrayList<>();
        // for(int num: nums) {
        //     if(num == 0) {
        //         zeros.add(num);
        //     } else if(num == 1) {
        //         ones.add(num);
        //     }
        // }
        // for(int i=0; i<zeros.size(); i++) {
        //     nums[i] = 0;
        // }
        // for(int i=zeros.size(); i<zeros.size()+ones.size(); i++) {
        //     nums[i] = 1;
        // }
        // for(int i=zeros.size()+ones.size(); i<nums.length; i++) {
        //     nums[i] = 2;
        // }
        // time = O(n) + O(n) = O(n)
        // space = O(n)

        // better (by counting)
        // int countZero=0, countOne=0;
        // for(int num: nums) {
        //     if(num == 0) countZero++;
        //     else if(num == 1) countOne++;
        // }
        // for(int i=0; i<countZero; i++) {
        //     nums[i] = 0;
        // }
        // for(int i=countZero; i<countZero+countOne; i++) {
        //     nums[i] = 1;
        // }
        // for(int i=countZero+countOne; i<nums.length; i++) {
        //     nums[i] = 2;
        // }
        // time = O(n)+O(n) = O(n)
        // space = O(1)

        // optimal (Dutch National Flag)
        // 0 to low-1 = 0's
        // low to mid-1 = 1's
        // mid to high = unsorted array
        // high to end = 2's
        int low=0, mid=0, high=nums.length-1;
        while(mid <= high) {
            if(nums[mid] == 0) {
                swap(nums,low++,mid++);
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                swap(nums,mid,high--);
            }
        }
        // time = O(n)
        // space = O(1)

    }

    void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
class Solution {
    public void rotate(int[] nums, int k) {
        // brute force 1
        // k = k%nums.length;
        // List<Integer>temp = new ArrayList<>();
        // for(int i=nums.length-k; i<nums.length; i++) {
        //     temp.add(nums[i]);
        // }
        // for(int i=0; i<nums.length-k; i++) {
        //     temp.add(nums[i]);
        // }
        // for(int i=0; i<temp.size(); i++) {
        //     nums[i] = temp.get(i);
        // }
        // time = O(n) + O(n) = O(n)
        // space = O(n)

         // brute force (better)
        // k=k%nums.length;
        // List<Integer>temp = new ArrayList<>();
        // for(int i=nums.length-k; i<nums.length; i++) {
        //     temp.add(nums[i]);
        // }
        // for(int i=nums.length-1; i>=k; i--) {
        //     nums[i] = nums[i-k];
        // }
        // for(int i=0; i<k; i++) {
        //     nums[i] = temp.get(i);
        // }
        // time = O(n)
        // space = O(k)

        // optimal
        k = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        // time = O(n)
        // space = O(1)
    }

    void reverse(int nums[], int start, int end) {
        while(start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
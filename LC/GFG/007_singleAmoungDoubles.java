class Solution {
    public int singleNumber(int[] nums) {
        // brute force
        // for(int i=0; i<nums.length; i++) {
        //     int count = 0;
        //     for(int j=0; j<nums.length; j++) {
        //         if(nums[i] == nums[j]) {
        //             count++;
        //         }
        //     }
        //     if(count == 1) {
        //         return nums[i];
        //     }
        // }
        // return -1;
        // time = O(n^2)
        // space = O(1)

        // better
        // Map<Integer,Integer>map = new HashMap<>();
        // for(int num: nums) {
        //     map.put(num, map.getOrDefault(num,0)+1);
        // }
        // for(Map.Entry<Integer,Integer>entry: map.entrySet()) {
        //     if(entry.getValue() == 1) {
        //         return entry.getKey();
        //     }
        // }
        // return -1;
        // time = O(n)+O(n) = O(n)
        // space = O(n)

        // optimal
        int xor = 0;
        for(int num: nums) {
            xor ^= num;
        }
        return xor;
        // time = O(n)
        // space = O(1)
        
    }
}
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // brute force
        // List<Integer> ans = new ArrayList<>();
        // for(int i=0; i<nums.length; i++) {
        //     if(ans.contains(nums[i])) continue;
        //     int count = 0;
        //     for(int j=0; j<nums.length; j++) {
        //         if(nums[i] == nums[j]) count++;
        //     }
        //     if(count > nums.length/3) ans.add(nums[i]);
        //     if(ans.size() == 2) return ans;
        // }
        // return ans;
        // time = O(n^2)
        // space = O(1)

        // better
        // List<Integer> ans = new ArrayList<>();
        // Map<Integer,Integer> map = new HashMap<>();
        // for(int num: nums) {
        //     map.put(num, map.getOrDefault(num,0)+1);
        // }
        // for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
        //     if(entry.getValue() > nums.length/3) ans.add(entry.getKey());
        //     if(ans.size() == 2) break;
        // }
        // return ans;
        // time = O(n)
        // space = O(n)

        // optimal (boyer moore majority vote algorithm)
        List<Integer> ans = new ArrayList<>();
        int count1=0, element1=0;
        int count2=0, element2=0;
        for(int num: nums) {
            if(count1==0 && num!=element2) {
                element1 = num;
                count1++;
            } else if(count2==0 && num!=element1) {
                element2 = num;
                count2++;
            } else if(num == element1) {
                count1++;
            } else if(num == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int num: nums) {
            if(num == element1) count1++;
            else if(num == element2) count2++;
        }
        if(count1 > nums.length/3) ans.add(element1);
        if(count2 > nums.length/3) ans.add(element2);
        return ans; 
        // time = O(n)
        // space = O(1)  
    }
}
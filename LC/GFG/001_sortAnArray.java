class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }

    void mergeSort(int nums[], int start, int end) {
        if(start == end) return;
        int mid = (start+end)/2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid+1, end);
        merge(nums, start, mid, end);
    }

    void merge(int nums[], int start, int mid, int end) {
        int left=start, right=mid+1;
        List<Integer>temp = new ArrayList<>();
        while(left<=mid && right<=end) {
            if(nums[left] <= nums[right]) {
                temp.add(nums[left++]); 
            } else {
                temp.add(nums[right++]);
            }
        }
        while(left <= mid) {
            temp.add(nums[left++]); 
        }
        while(right <= end) {
            temp.add(nums[right++]); 
        }
        for(int i=start; i<=end; i++) {
            nums[i] = temp.get(i-start);
        }
    }
}
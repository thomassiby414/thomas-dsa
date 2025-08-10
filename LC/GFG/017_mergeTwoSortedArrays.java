class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // brute force
        // List<Integer> temp = new ArrayList<>();
        // int i=0, j=0;
        // while(i<m && j<n) {
        //     if(nums1[i] <= nums2[j]) {
        //         temp.add(nums1[i++]);
        //     } else {
        //         temp.add(nums2[j++]);
        //     }
        // }
        // while(i < m) {
        //     temp.add(nums1[i++]);
        // }
        // while(j < n) {
        //     temp.add(nums2[j++]);
        // }
        // for(int k=0; k<m+n; k++) {
        //     nums1[k] = temp.get(k);
        // }
        // time = O(m+n)+O(m+n) = O(m+n)
        // space = O(m+n)

        // optimal 1
        // for(int i=0; i<n; i++) {
        //     nums1[i+m] = nums2[i];
        // }
        // Arrays.sort(nums1);
        // time = O(n)+O((m+n)log(m+n)) = O((m+n)log(m+n))
        // space = O(1)
        
        // optimal
        int i=m-1, j=n-1, k=m+n-1;
        while(i>=0 && j>=0) {
            if(nums2[j] >= nums1[i]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
        // time = O(m+n)
        // space = O(1)
    }
}
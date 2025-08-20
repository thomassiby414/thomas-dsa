class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // brute force
        // int m=nums1.length, n=nums2.length;
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
        // int mid = (m+n)/2;
        // if((m+n) % 2 == 0) {
        //     return (double)(temp.get(mid)+temp.get(mid-1))/2;
        // }
        // return (double)(temp.get(mid));
        // time = O(m+n)
        // space = O(m+n)

        // better
        // int m=nums1.length, n=nums2.length;
        // int mid = (m+n)/2;
        // int ind1=mid-1, ele1=-1;
        // int ind2=mid, ele2=-1;
        // int i=0, j=0, k=0;
        // while(i<m && j<n) {
        //     if(nums1[i] <= nums2[j]) {
        //         if(k == ind1) ele1 = nums1[i];
        //         if(k == ind2) ele2 = nums1[i];
        //         i++;
        //         k++;
        //     } else {
        //         if(k == ind1) ele1 = nums2[j];
        //         if(k == ind2) ele2 = nums2[j];
        //         j++;
        //         k++;
        //     }
        // }
        // while(i < m) {
        //     if(k == ind1) ele1 = nums1[i];
        //     if(k == ind2) ele2 = nums1[i];
        //     i++;
        //     k++;
        // }
        // while(j < n) {
        //     if(k == ind1) ele1 = nums2[j];
        //     if(k == ind2) ele2 = nums2[j];
        //     j++;
        //     k++;
        // }
        // if((m+n) % 2 == 0) {
        //     return (double)(ele1+ele2)/2;
        // }
        // return (double)(ele2);
        // time = O(m+n)
        // space = O(1)

        // optimal
        int m=nums1.length, n=nums2.length;
        if(m > n) return findMedianSortedArrays(nums2, nums1);
        int left = (m+n+1)/2;
        int start=0, end=m;
        while(start <= end) {
            int mid1 = (start+end)/2;
            int mid2 = left-mid1;
            int l1=Integer.MIN_VALUE, l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE, r2=Integer.MAX_VALUE;
            if(mid1 < m) r1 = nums1[mid1];
            if(mid2 < n) r2 = nums2[mid2];
            if(mid1-1 >= 0) l1 = nums1[mid1-1];
            if(mid2-1 >= 0) l2 = nums2[mid2-1];
            if(l1<=r2 && l2<=r1) {
                if((m+n) % 2 == 0) {
                    return (double)(Math.max(l1, l2) + Math.min(r1, r2))/2;
                }
                return (double)Math.max(l1, l2);
            } else if(l1 > r2) {
                end = mid1-1;
            } else {
                start = mid1+1;
            }
        }
        return -1;
        // time = O(log(min(m,n)))
        // space = O(1)
        
    }
}
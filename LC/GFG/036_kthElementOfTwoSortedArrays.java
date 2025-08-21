class Solution {
    public int kthElement(int a[], int b[], int k) {
        // brute force
        // int m=a.length, n=b.length;
        // List<Integer> temp = new ArrayList<>();
        // int i=0, j=0;
        // while(i<m && j<n) {
        //     if(a[i] <= b[j]) {
        //         temp.add(a[i++]);
        //     } else {
        //         temp.add(b[j++]);
        //     }
        // }
        // while(i < m) {
        //     temp.add(a[i++]);
        // }
        // while(j < n) {
        //     temp.add(b[j++]);
        // }
        // return temp.get(k-1);
        // time = O(m+n)
        // space = O(m+n)
        
        // better
        // int m=a.length, n=b.length;
        // int i=0, j=0, count=1;
        // while(i<m && j<n) {
        //     if(a[i] <= b[j]) {
        //         if(count == k) return a[i];
        //         i++;
        //         count++;
        //     } else {
        //         if(count == k) return b[j];
        //         j++;
        //         count++;
        //     }
        // }
        // while(i < m) {
        //     if(count == k) return a[i];
        //     i++;
        //     count++;
        // }
        // while(j < n) {
        //     if(count == k) return b[j];
        //     j++;
        //     count++;
        // }
        // return -1;
        // time = O(m+n)
        // space = O(1)
        
        // optimal
        int m=a.length, n=b.length;
        if(m > n) return kthElement(b, a, k);
        int start=Math.max(0, k-n), end=Math.min(k, m);
        while(start <= end) {
            int mid1 = (start+end)/2;
            int mid2 = k-mid1;
            int l1=Integer.MIN_VALUE, l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE, r2=Integer.MAX_VALUE;
            if(mid1 < m) r1 = a[mid1];
            if(mid2 < n) r2 = b[mid2];
            if(mid1-1 >= 0) l1 = a[mid1-1];
            if(mid2-1 >= 0) l2 = b[mid2-1];
            if(l1<=r2 && l2<=r1) {
                return Math.max(l1, l2);
            } else if(l1 > r2) {
                end = mid1-1;
            } else {
                start = mid1+1;
            }
        }
        return -1;
        // time = O(min(m,n))
        // space = O(1)
    }
}
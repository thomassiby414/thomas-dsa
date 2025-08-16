class Solution {
    public int findKthPositive(int[] arr, int k) {
        // brute force
        // for(int num: arr) {
        //     if(num <= k) {
        //         k++;
        //     } else {
        //         return k;
        //     }
        // }
        // return k;
        // time = O(n)

        // optimal
        int start=0, end=arr.length-1;
        while(start <= end) {
            int mid = (start+end)/2;
            if(arr[mid]-(mid+1) < k) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return end+1+k;
        // time = O(logn)

        // formula
        // ind 0 1 2 3 4
        // arr 2 3 4 7 11
        // mis 1 1 1 3 6   missing(i) = arr[i]-(i+1)
        // start=4, end=3
        // ans = arr[end] + k - missing(end)
        //     = arr[end] + k - (arr[end] - (end + 1))
        //     = arr[end] + k - (arr[end] - end - 1)
        //     = arr[end] + k -arr[end] + end + 1
        // ans = k+end+1

    }
}
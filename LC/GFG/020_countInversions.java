class Solution {
    static int inversionCount(int arr[]) {
        // brute force
        // int count = 0;
        // for(int i=0; i<arr.length; i++) {
        //     for(int j=i+1; j<arr.length; j++) {
        //         if(arr[i] > arr[j]) {
        //             count++;
        //         }
        //     }
        // }
        // return count;
        // time = O(n^2)
        // space = O(1)
        
        // optimal (modified merge sort)
        return mergeSort(arr,0,arr.length-1);
        // time = O(nlogn)
        // space = O(1)
    }
    
    static int mergeSort(int arr[], int start, int end) {
        int count = 0;
        if(start >= end) return count;
        int mid = (start+end)/2;
        count += mergeSort(arr,start,mid);
        count += mergeSort(arr,mid+1,end);
        count += merge(arr,start,mid,end);
        return count;
    }
    
    static int merge(int arr[], int start, int mid, int end) {
        int count = 0;
        List<Integer> temp = new ArrayList<>();
        int left=start, right=mid+1;
        while(left<=mid && right<=end) {
            if(arr[left] > arr[right]) {
                temp.add(arr[right++]);
                count += mid-left+1;
            } else {
                temp.add(arr[left++]);
            }
        }
        while(left <= mid) {
            temp.add(arr[left++]);
        }
        while(right <= end) {
            temp.add(arr[right++]);
        }
        for(int i=start; i<=end; i++) {
            arr[i] = temp.get(i-start);
        }
        return count;
    }
}
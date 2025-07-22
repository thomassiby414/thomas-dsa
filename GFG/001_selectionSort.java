class Solution {
    void selectionSort(int[] arr) {
        
        //normal selection sort
        // for(int i=0;i<arr.length-1;i++) {
        //     int minIndex = i;
        //     for(int j=i+1;j<arr.length;j++) {
        //         if(arr[j] < arr[minIndex]) {
        //             minIndex = j;
        //         }
        //     }
        //     int temp = arr[minIndex];
        //     arr[minIndex] = arr[i];
        //     arr[i] = temp;
        // }
        
        for(int i=0;i<arr.length-1;i++) {
            int minIndex = i;
            for(int j=i+1;j<arr.length;j++) {
                if(arr[minIndex]>arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        
        //recursion selection sort
        // recSelSort(arr,0);
        
    }
    
    
    //recursion selction osrt function
    void recSelSort(int arr[],int begIndex) {
        if(begIndex == arr.length-1) {
            return;
        }
        int minIndex = begIndex;
        for(int i=begIndex+1;i<arr.length;i++) {
            if(arr[minIndex] > arr[i]) {
                minIndex = i;
            }
        }
        int temp = arr[minIndex];
        arr[minIndex] = arr[begIndex];
        arr[begIndex] = temp;
        recSelSort(arr,begIndex+1);
    }
    
}
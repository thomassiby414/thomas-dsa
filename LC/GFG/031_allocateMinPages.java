class Solution {
    public int findPages(int[] arr, int k) {
        // brute force
        // if(k > arr.length) return -1;
        // int minPage=Integer.MIN_VALUE, maxPage=0;
        // for(int pages: arr) {
        //     minPage = Math.max(minPage, pages);
        //     maxPage += pages;
        // }
        // for(int page=minPage; page<=maxPage; page++) {
        //     if(isPagePossible(arr, page, k)) {
        //         return page;
        //     }
        // }
        // return -1;
        // time = O(n)+O(nm) = O(nm) where m = sum(arr)-max(arr)
        // space = O(1)
        
        // optimal
        int ans = -1;
        if(k > arr.length) return ans;;
        int minPages=Integer.MIN_VALUE, maxPages=0;
        for(int pages: arr) {
            minPages = Math.max(minPages, pages);
            maxPages += pages;
        }
        int start=minPages, end=maxPages;
        while(start <= end) {
            int page = (start+end)/2;
            if(isPagePossible(arr, page, k)) {
                ans = page;
                end = page-1;
            } else {
                start = page+1;
            }
        }
        return ans;
        // time = O(n)+O(nlogm) = O(nlogm) where m =sum(arr)-max(arr)
        // space = O(1)
    }
    
    boolean isPagePossible(int arr[], int page, int k) {
        int totalPages=0, studentCount=1;
        for(int pages: arr) {
            totalPages += pages;
            if(totalPages > page) {
                studentCount++;
                totalPages = pages;
            }
        }
        if(studentCount <= k) return true;
        return false;
    }
}
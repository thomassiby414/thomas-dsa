class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // brute force
        // int duplicate=-1, missing=-1;
        // for(int i=1; i<=arr.length; i++) {
        //     int count = 0;
        //     for(int j=0; j<arr.length; j++) {
        //         if(arr[j] == i) {
        //             count++;
        //         }
        //     }
        //     if(count > 1) duplicate = i;
        //     else if(count == 0) missing = i;
        //     if(duplicate!=-1 && missing!=-1) break;
        // }
        // return new ArrayList<>(Arrays.asList(duplicate, missing));
        // time = O(n^2)
        // space = O(1)
        
        // better
        // int duplicate=-1, missing=-1;
        // int count[] = new int[arr.length+1];
        // for(int num: arr) {
        //     count[num]++;
        // }
        // for(int i=1; i<count.length; i++) {
        //     if(count[i] > 1) duplicate = i;
        //     else if(count[i] == 0) missing =i;
        //     if(duplicate!=-1 && missing!=-1) break;
        // }
        // return new ArrayList<>(Arrays.asList(duplicate,missing));
        // time = O(n)+O(n) = O(n)
        // space = O(n)
        
        // optimal (sum method)
        long n = arr.length;
        long sum1=0, sum2=0;
        long summation1=(n*(n+1))/2, summation2=(n*(n+1)*(2*n+1))/6;
        for(long num: arr) {
            sum1 += num;
            sum2 += num*num;
        }
        long val1 = sum1-summation1; // x-y
        long val2 = sum2-summation2; // x^2-y^2
        // x^2-y^2 = (x-y)(x+y)
        // x+y = (x^2-y^2)/(x-y)
        val2 = val2/val1;
        // x+y+x-y = 2x
        long x = (val1+val2)/2;
        long y = val2-x;
        return new ArrayList<>(Arrays.asList((int)x,(int)y));
        
        
        
    }
}

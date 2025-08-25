class Solution {
    public String reverseWords(String s) {
        // brute force
        // StringBuilder ans = new StringBuilder();
        // String arr[] = s.trim().split("\\s+");
        // int n = arr.length;
        // for(int i=n-1; i>=0; i--) {
        //     ans.append(arr[i]);
        //     if(i > 0) ans.append(" ");
        // }
        // return ans.toString();
        // time = O(n)
        // space = O(n)

        // optimal
        StringBuilder ans = new StringBuilder();
        int i = s.length()-1;
        while(i >= 0) {
            while(i>=0 && s.charAt(i)==' ') i--;
            if(i < 0) break;
            int end = i;
            while(i>=0 && s.charAt(i)!=' ') i--;
            int start = i+1;
            if(ans.length() > 0) ans.append(" ");
            ans.append(s.substring(start, end+1));
        }
        return ans.toString();
        // time = O(n)
        // space = O(1)
    }
}
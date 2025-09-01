class Solution {
    public String longestPalindrome(String s) {
        // brute force
        // String ans = "";
        // int n = s.length();
        // for(int i=0; i<n; i++) {
        //     for(int j=i; j<n; j++) {
        //         if(isPalindrome(s,i,j)) {
        //             int length = j-i+1;
        //             if(length > ans.length()) {
        //                 ans = s.substring(i, j+1);
        //             }
        //         }
        //     }
        // }
        // return ans;
        // time = O(n^3)
        // space = O(1)

        // better
        String ans = "";
        int n = s.length();
        for(int i=0; i<n; i++) {
            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i+1);
            String longer = odd.length() > even.length() ? odd : even;
            if(longer.length() > ans.length()) {
                ans = longer;
            }
        }
        return ans;
        // time = O(n^2)
        // space = O(1)
    }

    String expandFromCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }

    boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
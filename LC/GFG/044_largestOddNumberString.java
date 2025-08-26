class Solution {
    public String largestOddNumber(String num) {
        // optimal
        for(int i=num.length()-1; i>=0; i--) {
            // Character.getNumericValue(num.charAt(i));
            // Integer.parseInt(String.valueOf(num.charAt(i)));
            int ele = num.charAt(i)-'0';
            if(ele % 2 == 0) continue;
            return num.substring(0, i+1);
        }
        return "";
        // time = O(n)
        // space = O(1)
    }
}
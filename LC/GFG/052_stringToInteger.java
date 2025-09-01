class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0, num = 0, sign = 1;
        // skip spaces
        while(i < n && s.charAt(i) == ' ') i++;
        // handle sign
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }
        // convert digits
        while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';
            // Overflow check
            if (num > Integer.MAX_VALUE / 10 || 
                (num == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num*10+digit;
            i++;
        }
        return num*sign;
        // time = O(n)
        // space = O(1)
    }
}
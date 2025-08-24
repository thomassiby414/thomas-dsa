class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for(char c: s.toCharArray()) {
            if (c == '(') {
                if (count > 0) ans.append(c);
                count++;
            } else {
                count--;
                if (count > 0) ans.append(c);
            }
        }
        return ans.toString();
        // time = O(n)
        // space = O(n)

        // String in Java is immutable
        // Everytime you do ans+=c, Java creates a new String Object, copies all old characters
        // + the new one, and assigns it back.
        // That makes concatenation inside a loop O(n²) in the worst case.
        // That's why we use StringBuilder
    }
}
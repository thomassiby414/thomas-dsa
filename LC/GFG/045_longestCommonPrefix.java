class Solution {
    public String longestCommonPrefix(String[] strs) {
        // brute force
        // if(strs.length == 0) return "";
        // String prefix = strs[0];
        // while(prefix.length() >= 0) {
        //     boolean flg = true;
        //     for(int i=1; i<strs.length; i++) {
        //         if(!strs[i].startsWith(prefix)) {
        //             flg = false;
        //             break;
        //         }
        //     }
        //     if(flg) return prefix;
        //     prefix = prefix.substring(0, prefix.length()-1);
        // }
        // return "";
        // time = O(n*m), where m=length of the first string
        // m^2 coz susbstring creation is costly
        //  and n=size of the array
        // space = O(1)

        // optimal
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for(int i=1; i<strs.length; i++) {
            while(!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
        // time = O(n*m)
        // space = O(1)
    }
}
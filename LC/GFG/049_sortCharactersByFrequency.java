class Solution {
    public String frequencySort(String s) {
        // optimal (bucket method)
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        List<Character> arr[] = new List[n+1];
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            int count = entry.getValue();
            if(arr[count] == null) {
                arr[count] = new ArrayList<>();
            }
            arr[count].add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for(int i=n; i>0; i--) {
            if(arr[i] != null) {
                for(char c: arr[i]) {
                    for(int j=0; j<i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
        // time = O(n)+O(n)+O(n) = O(n)
        // space = O(n)+O(n)+O(n) = O(n)

        // heap method
        // int n = s.length();
        // Map<Character, Integer> map = new HashMap<>();
        // for(int i=0; i<n; i++) {
        //     char ch = s.charAt(i);
        //     map.put(ch, map.getOrDefault(ch, 0)+1);
        // }
        // PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
        //     (a,b) -> b.getValue()-a.getValue()
        // );
        // pq.addAll(map.entrySet());

        // StringBuilder sb = new StringBuilder();
        // while(!pq.isEmpty()) {
        //     Map.Entry<Character, Integer> entry = pq.poll();
        //     for(int i=0; i<entry.getValue(); i++) {
        //         sb.append(entry.getKey());
        //     }
        // }
        // return sb.toString();
        // time = O(nlogk), k=no. of unique charcters
        // space = O(n)
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String val = new String(arr);

            if(!map.containsKey(val)){
                map.put(val, new ArrayList<>());
            }

            map.get(val).add(s);
            
        }

       
        return new ArrayList<>(map.values());
    }
}
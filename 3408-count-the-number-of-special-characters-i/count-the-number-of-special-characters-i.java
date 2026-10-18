import java.util.*;
class Solution {
    public int numberOfSpecialChars(String word) {
        TreeMap<Character, Integer> map1 = new TreeMap<>();
        TreeMap<Character, Integer> map2 = new TreeMap<>();

        for(char c : word.toCharArray()){
            if(Character.isUpperCase(c)) map1.put(c, map1.getOrDefault(c, 0) + 1);
            else map2.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for(Map.Entry<Character, Integer> entry1 : map1.entrySet()){
            for(Map.Entry<Character, Integer> entry2 : map2.entrySet()){
                if(entry1.getKey() == Character.toUpperCase(entry2.getKey()) && entry1.getValue() >= entry2.getValue()) {
                    count++; 
                }
            }
        }

        System.out.println(map1 + "\n" + map2);
        return count;
    }
}
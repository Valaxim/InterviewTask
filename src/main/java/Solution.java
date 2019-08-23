import java.util.*;

public class Solution {

    final static String INPUT = "ala ma kota, kot koduje w Javie kota";

    public void solve() {
        String correctInput = removeNonAlphanumericCharacters(INPUT);
        String[] strings = separateInput(correctInput);
        HashSet<String> strings1 = eliminateDuplicateToLowerCase(strings);
        Map<Character, Set<String>> map = createMap(strings1);
        printMap(map);
    }

    public String removeNonAlphanumericCharacters(String input) {
        return input.replaceAll("[^a-zA-Z]", " ");
    }

    public String[] separateInput(String input) {
        return input.split(" ");
    }

    public HashSet<String> eliminateDuplicateToLowerCase(String[] input) {
        HashSet<String> set = new HashSet<>();
        for (String item : input) {
            if (item.length() != 0) {
                set.add(item.toLowerCase());
            }
        }
        return set;
    }

    public Map<Character, Set<String>> createMap(HashSet<String> set) {
        Map<Character, Set<String>> maps = new HashMap<>();

        for (String item : set) {
            for (int i = 0; i < item.length(); i++) {
                char c = item.charAt(i);
                if (maps.get(c) == null) {
                    Set <String> list = new TreeSet<>();
                    list.add(item);
                    maps.put(c, list);
                } else {
                    Set<String> strings = maps.get(c);
                    strings.add(item);
                    maps.put(c, strings);
                }
            }
        }
        return maps;
    }

    public void printMap(Map <Character, Set<String>> map) {
        StringBuffer buffer = new StringBuffer();
        for (Character chars : map.keySet()) {
            buffer.append(chars + ": ");
            buffer.append(String.join(", ", map.get(chars)) + "\n");
        }
        System.out.println(buffer.toString());
    }
}

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    @Test
    public void removeNonAlphanumericCharactersDigitsTest() {
       Solution solution = new Solution();
        String result = solution.removeNonAlphanumericCharacters("Test1test");
        assertEquals("Test test", result);
    }

    @Test
    public void sepateInputTest() {
        Solution solution = new Solution();
        String [] result = solution.separateInput("My input data");
        assertEquals(3, result.length);
        assertEquals("My", result[0]);
        assertEquals("input", result[1]);
        String[] expectedResult = {"My", "input", "data"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void eliminateDuplicateWordsToLowerCaseTest() {
        Solution solution = new Solution();
        String [] input = new String [] {"Word1", "Word2", "Duplicate", "Duplicate"};
        HashSet<String> set = solution.eliminateDuplicateToLowerCase(input);
        HashSet<String> expectedResult = new HashSet<>(Arrays.asList("word1", "word2", "duplicate"));
        assertEquals(set, expectedResult);
    }

    @Test
    public void createMapTest() {
        Solution solution = new Solution();
        Map<Character, Set<String>> map = solution.createMap(new HashSet<>(Arrays.asList("test")));
        Map<Character, Set<String>> expectedMap = new HashMap<>();
        expectedMap.put('t', new HashSet<>(Arrays.asList("test")));
        expectedMap.put('e', new HashSet<>(Arrays.asList("test")));
        expectedMap.put('s', new HashSet<>(Arrays.asList("test")));
        assertEquals(map, expectedMap);
    }

}

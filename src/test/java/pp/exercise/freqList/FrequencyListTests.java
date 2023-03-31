package pp.exercise.freqList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pp.exercise.freqList.domain.FrequencyList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FrequencyListTests {
    private FrequencyList frequencyList;
    private HashMap<String, Integer> map = new HashMap<String, Integer>() {{
        put("the", 2);
        put("of", 4);
        put("this", 1);
    }};

    @BeforeEach
    public void testSetup() {
        frequencyList = new FrequencyList(map);
    }

    @Test
    public void whenAddingOccurence_ValueIncrements() {
        frequencyList.addOccurrence("the");
        assertTrue(frequencyList.getMap().get("the") == 3);
    }

    @Test
    public void whenAddingWord_HasValue1() {
        frequencyList.addNewWord("newWord");
        assertTrue(frequencyList.getMap().get("newWord") == 1);
    }

    @Test
    public void whenReverseSort_OrderIsDescending() {
        frequencyList.reverseSort();
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(frequencyList.getMap().entrySet());

        assertEquals("of", wordList.get(0).getKey());
        assertEquals("the", wordList.get(1).getKey());
        assertEquals( "this", wordList.get(2).getKey());
    }
}

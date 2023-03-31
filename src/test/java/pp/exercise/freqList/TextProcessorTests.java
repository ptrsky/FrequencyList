package pp.exercise.freqList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pp.exercise.freqList.domain.FrequencyList;
import pp.exercise.freqList.domain.TextProcessor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TextProcessorTests {
    private TextProcessor textProcessor = new TextProcessor();
    @Test
    public void inputStream_UpperCaseIgnored(){
        String input = "Two two of two The word the";
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        FrequencyList fl = textProcessor.calculateFrequencyList(stream);

        assertTrue(fl.getMap().get("two") == 3);
        assertTrue(fl.getMap().get("of") == 1);
        assertTrue(fl.getMap().get("the") == 2);
        assertTrue(fl.getMap().get("word") == 1);
    }

    @Test
    public void inputStream_PunctuationIgnored(){
        String input = "two: two, three! and... one-two";
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        FrequencyList fl = textProcessor.calculateFrequencyList(stream);

        assertTrue(fl.getMap().get("two") == 2);
        assertTrue(fl.getMap().get("one-two") == 1);
        assertTrue(fl.getMap().get("three") == 1);
        assertTrue(fl.getMap().get("and") == 1);
    }

    @Test
    public void inputStream_emptyInput(){
        String input = "";
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        FrequencyList fl = textProcessor.calculateFrequencyList(stream);

        assertTrue(fl.getMap().isEmpty());
    }
}

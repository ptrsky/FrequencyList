package pp.exercise.freqList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import pp.exercise.freqList.domain.FrequencyList;
import pp.exercise.freqList.domain.TextProcessor;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TextProcessorTests {
    private final TextProcessor textProcessor = new TextProcessor();
    @Test
    public void inputStream_UpperCaseIgnored(){
        FrequencyList fl = textProcessor.generateFrequencyList(
                createFileWithText("Two two of two The word the"));

        assertTrue(fl.getMap().get("two") == 3);
        assertTrue(fl.getMap().get("of") == 1);
        assertTrue(fl.getMap().get("the") == 2);
        assertTrue(fl.getMap().get("word") == 1);
    }

    @Test
    public void inputStream_PunctuationIgnored(){
        FrequencyList fl = textProcessor.generateFrequencyList(
                createFileWithText("two: two, three! and... one-two"));

        assertTrue(fl.getMap().get("two") == 2);
        assertTrue(fl.getMap().get("one-two") == 1);
        assertTrue(fl.getMap().get("three") == 1);
        assertTrue(fl.getMap().get("and") == 1);
    }

    @Test
    public void inputStream_emptyInput(){
        FrequencyList fl = textProcessor.generateFrequencyList(
                createFileWithText(""));
        assertTrue(fl.getMap().isEmpty());
    }

    private MockMultipartFile createFileWithText(String text) {
        return new MockMultipartFile(
                "file",
                "hello.txt",
                MediaType.TEXT_PLAIN_VALUE,
                text.getBytes()
        );
    }
}

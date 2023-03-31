package pp.exercise.freqList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import pp.exercise.freqList.domain.ListFacade;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ListFacadeTests {
    private ListFacade listFacade = new ListFacade();

    @Test
    public void whenFileGiven_ReverseDictionaryMapIsReturned() {
        MockMultipartFile inputFile
                = new MockMultipartFile(
                "file",
                "hello.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Long long long long time ago, before the wind, before the snow...".getBytes()
        );

        HashMap<String, Integer> output = listFacade.processText(inputFile);
        assertTrue(output.get("long") == 4);
        assertTrue(output.get("before") == 2);
        assertTrue(output.get("the") == 2);
        assertTrue(output.get("wind") == 1);
        assertTrue(output.get("snow") == 1);
        assertTrue(output.get("time") == 1);
        assertTrue(output.get("ago") == 1);
    }
}

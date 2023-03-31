package pp.exercise.freqList.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

public class ListFacade implements ListApi{

    private TextProcessor textProcessor = new TextProcessor();
    @Override
    public HashMap<String, Integer> processText(MultipartFile file) {
        try {
            return textProcessor
                    .calculateFrequencyList(file.getInputStream())
                    .reverseSort()
                    .getMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

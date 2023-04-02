package pp.exercise.freqList.domain;

import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

public class ListFacade implements ListApi{

    private final TextProcessor textProcessor = new TextProcessor();
    @Override
    public HashMap<String, Integer> processText(MultipartFile file) {
        return textProcessor
                .generateFrequencyList(file)
                .reverseSort()
                .getMap();
    }
}

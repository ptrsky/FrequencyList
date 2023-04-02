package pp.exercise.freqList.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Scanner;

public class TextProcessor {

    private final static String ENCODING_TYPE = "UTF-8";

    public FrequencyList generateFrequencyList(MultipartFile file) {
        FrequencyList frequencyList = new FrequencyList();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file.getInputStream(), ENCODING_TYPE);
            while (scanner.hasNext()) {
                String word = normalize(scanner.next());

                if (frequencyList.getMap().containsKey(word))
                    frequencyList.addOccurrence(word);
                else
                    frequencyList.addNewWord(word);
            }
            if (scanner.ioException() != null) {
                throw scanner.ioException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return frequencyList;
    }

    private String normalize(String inputWord) {
        return inputWord.toLowerCase()
                .replaceAll("^(\\p{P}+\\s*)|(\\p{P}+\\s*)+$", "");
    }

}

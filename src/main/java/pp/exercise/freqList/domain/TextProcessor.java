package pp.exercise.freqList.domain;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class TextProcessor {

    public FrequencyList calculateFrequencyList(InputStream inputStream) {
        FrequencyList frequencyList = new FrequencyList();
        Scanner scanner = null;
        try {
            scanner = new Scanner(inputStream, "UTF-8"); //założenie: kodowanie w UTF-8
            while (scanner.hasNext()) {
                String word = normalize(scanner.next());

                if (frequencyList.getMap().containsKey(word)) {
                    frequencyList.addOccurrence(word);
                } else {
                    frequencyList.addNewWord(word);
                }
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
        return inputWord.toLowerCase().replaceAll("\\p{Punct}+$", "");
    }

}
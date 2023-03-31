package pp.exercise.freqList.domain;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyList {
    private HashMap<String, Integer> map;

    public FrequencyList() {
        map = new HashMap<>();
    }

    public FrequencyList(HashMap<String, Integer> map) {
        this.map = map;
    }

    public HashMap<String, Integer> getMap() {
        return map;
    }

    public void addOccurrence(String word) {
        map.replace(word, map.get(word) + 1);
    }

    public void addNewWord(String word) {
        map.put(word, 1);
    }

    public FrequencyList reverseSort() {
        map = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return this;
    }
}

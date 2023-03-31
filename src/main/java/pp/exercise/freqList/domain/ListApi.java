package pp.exercise.freqList.domain;

import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

public interface ListApi {
    HashMap<String, Integer> processText(MultipartFile file);
}

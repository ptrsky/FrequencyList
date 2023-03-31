package pp.exercise.freqList.domain;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@RestController
public class ListController {
    private ListApi listApi = new ListFacade();

    @GetMapping("/frequencyList")
    public ResponseEntity<HashMap<String, Integer>> frequencyList(@RequestPart("file") MultipartFile file) {
        return file.isEmpty() ?
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
                : ResponseEntity.ok(listApi.processText(file));
    }


}

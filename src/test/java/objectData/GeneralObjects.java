package objectData;

import com.fasterxml.jackson.databind.ObjectMapper;
import pages.PracticeForm;

import java.io.File;
import java.io.IOException;

public class GeneralObjects {

    protected void fromJsontoObject(String filePath) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
             objectMapper.readerForUpdating(this).readValue(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

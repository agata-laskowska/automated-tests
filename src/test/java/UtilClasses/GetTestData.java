package UtilClasses;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GetTestData {

    public JSONObject getTestData() throws IOException, ParseException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource("test-data.json").getFile());

        String content = new String(Files.readAllBytes(file.toPath()));

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(content);

        return jsonObject;
    }
}

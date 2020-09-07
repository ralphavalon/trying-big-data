package com.data.big.trying.tryingbigdata.helper;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Files;

public class JsonHelper {

    public static final String loadTemperatureRequest(String filename) throws Exception {
        return loadFile("classpath:requests/temperature/" + filename + ".json");
    }

    public static final String loadTemperatureResponse(String filename) throws  Exception {
        return loadFile("classpath:responses/temperature/" + filename + ".json");
    }

    private static String loadFile(String filePath) throws Exception {
        File file = ResourceUtils.getFile(filePath);
        return new String(Files.readAllBytes(file.toPath()));
    }
}

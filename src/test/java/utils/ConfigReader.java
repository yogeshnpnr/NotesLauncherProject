package utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConfigReader {
    private static JSONObject envConfig;

    static {
        loadJsonConfig();
    }

    // Load env.json
    private static void loadJsonConfig() {
        try (FileInputStream fis = new FileInputStream("src\\test\\java\\resources/env.json")) {
            JSONParser parser = new JSONParser();
            envConfig = (JSONObject) parser.parse(new String(fis.readAllBytes()));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load env.json");
        }
    }

    // Get value from env.json
    public static Object getEnvValue(String key) {
        return envConfig.get(key);
    }

    // Get value as String
    public static String getEnvString(String key) {
        return String.valueOf(envConfig.get(key));
    }
}

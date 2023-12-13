package design;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseDataDemo {
    public static Map<String, List<String>> parse(String jsonData) {
        Map<String, List<String>> map = new HashMap<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            // Parse JSON to List of Maps
            List<Map<String, String>> list = mapper.readValue(jsonData, new TypeReference<Object>() {});

            // Convert to Map<String, List<String>>
            for (Map<String, String> item : list) {
                for (Map.Entry<String, String> entry : item.entrySet()) {
                    map.computeIfAbsent(entry.getKey(), k -> new ArrayList<>()).add(entry.getValue());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
}

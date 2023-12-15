package design;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ParseDataDemoTest {

    @Test
    void parse() {
        String jsonString = "[{\"A\":\"a\", \"B\":\"b\"}]";
        Map<String, List<String>> expected = Map.of("A", List.of("a"), "B", List.of("b"));
        Map<String, List<String>> result = ParseDataDemo.parse(jsonString);
        assertEquals(expected, result);
    }

    @Test
    void parse1() throws IOException {
        String jsonString = """
                [
                  {
                    "category": "test",
                    "url": "www.abc.com",
                    "method": "GET",
                    "count": 1,
                    "callSuccessful": true,
                    "errors": []
                  },
                    {
                    "category": "test1",
                    "url": "www.google.com",
                    "method": "GET",
                    "count": 1,
                    "callSuccessful": true,
                    "errors": []
                  }
                  ]""";
        List<Map<String, Object>> result = new ObjectMapper().readValue(jsonString, new TypeReference<>() {});
        assertEquals(2, result.size());
        assertEquals("www.abc.com", result.get(0).get("url"));
        assertEquals("www.google.com", result.get(1).get("url"));
    }

    @Test
    void parseUpstream() {
        String jsonString = "{\"1\":[\"one\"]}\n";
    }
}


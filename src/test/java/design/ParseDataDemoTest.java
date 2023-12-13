package design;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ParseDataDemoTest {

    @Test
    void parse() {
        String jsonString = "[{\"A\":\"a\", \"B\":\"b\"}]";
        Map<String, List<String>> expected = Map.of("A",List.of("a"),"B",List.of("b"));
        Map<String, List<String>> result = ParseDataDemo.parse(jsonString);
        assertEquals(expected, result);
    }
}
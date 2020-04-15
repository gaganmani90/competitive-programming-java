import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileOperations {
    public static void main(String[] args) throws IOException {
        writeFile("gagan mani is the best -- yo", "./gagan/test/text.txt");
    }

    private static void writeFile(String text, String path) throws IOException {
        FileUtils.writeStringToFile(new File(path), text, Charset.defaultCharset());
    }
}

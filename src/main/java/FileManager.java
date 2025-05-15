import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    public void saveToFile(String content, String directory, String fileName) throws IOException {
        File dir = new File(directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(dir, fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
            System.out.println("JSON file created at: " + file.getAbsolutePath());
        }
    }
}

package decorator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class StringToFileWriterAndReaderAndReader implements WriterAndReader {
    private final String filePath;

    public StringToFileWriterAndReaderAndReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(String message) {
        File file = new File(filePath);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);){
            fileOutputStream.write(message.getBytes(StandardCharsets.UTF_8), 0,message.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String readFile() {
        char[] buffer = null;
        File file = new File(filePath);
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new String(buffer);
    }
}

package decorator;

public interface WriterAndReader {
    void write(String message);

    String readFile();
}

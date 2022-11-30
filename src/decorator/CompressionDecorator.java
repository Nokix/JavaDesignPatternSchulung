package decorator;

public class CompressionDecorator implements WriterAndReader {
    WriterAndReader wrappee;
    public CompressionDecorator(WriterAndReader wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void write(String message) {
        wrappee.write(message);
    }

    @Override
    public String readFile() {
        return wrappee.readFile();
    }
}

package decorator;

public class Demo {
    public static void main(String[] args) {
        String message = "Viktor Reichert. Persönliche Informationen. Geheim, geheim.";

        String filePath = "out/secret.txt";

        WriterAndReader writerAndReader = new EncryptDecorator(new StringToFileWriterAndReaderAndReader(filePath));

        writerAndReader.write(message);

        StringToFileWriterAndReaderAndReader frar = new StringToFileWriterAndReaderAndReader(filePath);
        System.out.println("Inhalt der Datei:");
        System.out.println(frar.readFile());
        System.out.println();
        System.out.println("Entschüsselt:");
        System.out.println(writerAndReader.readFile());



    }
}

package decorator;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncryptDecorator implements WriterAndReader {
    WriterAndReader wrappee;

    public EncryptDecorator(WriterAndReader wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void write(String message) {
        wrappee.write(encrypt(message));
    }

    private String encrypt(String message) {
        byte[] bytes = message.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(bytes);
    }

    @Override
    public String readFile() {
        return decode(wrappee.readFile());
    }

    private String decode(String encryptedStr) {
        byte[] bytes = Base64.getDecoder().decode(encryptedStr);
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] -= 1;
        }
        return new String(bytes);
    }


}

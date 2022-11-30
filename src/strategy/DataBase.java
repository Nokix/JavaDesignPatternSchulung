package strategy;

import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidParameterException;

public class DataBase {
    String fileName;
    ResponseStrategy responseStrategy = (r, e) -> {};

    public DataBase(String fileName) {
        this.fileName = fileName;
    }

    public DataBase(String fileName, ResponseStrategy responseStrategy) {
        this.fileName = fileName;
        this.responseStrategy = responseStrategy;
    }

    public void log(String s, ResponseStrategy currentStrategy) {
        Exception e = null;
        try(FileWriter fileWriter = new FileWriter(fileName, true)) {
            if(s.trim().equals("")) throw new InvalidParameterException();
            fileWriter.write(s);
        } catch (InvalidParameterException | IOException ex) {
            e = ex;
        }
        currentStrategy.handle(s, e);
    }

    public void log(String s) {
        log(s, this.responseStrategy);
    }
}

package strategy;

public interface ResponseStrategy {
    void handle(String response, Exception e);
}

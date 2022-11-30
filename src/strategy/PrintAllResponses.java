package strategy;

public class PrintAllResponses implements ResponseStrategy {

    @Override
    public void handle(String response, Exception e) {
        if(e != null) e.printStackTrace();
        else System.out.println(response);;
    }
}

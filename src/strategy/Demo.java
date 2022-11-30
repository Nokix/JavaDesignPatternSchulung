package strategy;

public class Demo {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase("out/db.txt", new PrintAllResponses());

        dataBase.log("    ");
        dataBase.log("Hallo");
        dataBase.log("duda", ((response, e) -> {}));
        dataBase.log("hallo");
    }
}

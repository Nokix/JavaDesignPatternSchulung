package chain_of_responsibility;

import java.util.HashMap;
import java.util.Map;

public class Server {
    private Map<String, String> mailPasswordMap = new HashMap<>();
    private Map<String, UserType> mailTypeMap = new HashMap<>();
    private Handler loginHandler;

    public void register(String email, String password, UserType userType) {
        mailTypeMap.put(email, userType);
        mailPasswordMap.put(email, password);
    }

    public void setLoginHandler(Handler loginHandler) {
        this.loginHandler = loginHandler;
    }

    public boolean logIn(String email,String password) {
        if (this.loginHandler != null && this.loginHandler.handle(email, password)) {
            System.out.println("Login success.");
            return true;
        }
        return false;
    }

    public boolean userExist(String email) {
        return mailPasswordMap.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return mailPasswordMap.containsKey(email) && mailPasswordMap.get(email).equals(password);
    }
}

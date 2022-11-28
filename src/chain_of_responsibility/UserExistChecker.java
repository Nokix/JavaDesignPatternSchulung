package chain_of_responsibility;

public class UserExistChecker extends Handler {

    private final Server server;


    public UserExistChecker(Server server) {
        this.server = server;
    }

    @Override
    public boolean handle(String email, String password) {
        if (!server.userExist(email)) {
            System.out.println("User not found");
            return false;
        }
        System.out.println("User found");
        return this.handleNext(email, password);
    }
}

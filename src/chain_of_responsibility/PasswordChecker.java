package chain_of_responsibility;

public class PasswordChecker extends Handler {
    private Server server;

    public PasswordChecker(Server server) {
        this.server = server;
    }

    @Override
    public boolean handle(String email, String password) {
        if (!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        return handleNext(email, password);
    }
}

package chain_of_responsibility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.register("Vasil@Aleksandrov.de", "1233456", UserType.USER);
        server.register("Ivan@Khanenko.de", "sicheresPassword", UserType.ADMIN);

        server.setLoginHandler(Handler.link(
                new ThrottlingChecker(3),
                new UserExistChecker(server),
                new PasswordChecker(server))
        );

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean success = false;
        do {
            System.out.println("Enter email:");
            String email = reader.readLine();
            System.out.println("Enter password:");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);
    }
}

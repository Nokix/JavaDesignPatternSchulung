package chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;

public class ThrottlingChecker extends Handler{
    private final int max_num_requests_per_minute;
    private final List<Long> timeOfRequest = new ArrayList<>();

    public ThrottlingChecker(int max_num_requests_per_minute) {
        this.max_num_requests_per_minute = max_num_requests_per_minute;
    }

    @Override
    public boolean handle(String email, String password) {
        if (checkIfTooMany()) {
            System.out.println("Too many requests. Slow down.");
            return false;
        }
        return this.handleNext(email,password);
    }

    private boolean checkIfTooMany() {
        long currentTimeMillis = System.currentTimeMillis();
        timeOfRequest.add(currentTimeMillis);
        long requestsInLastMinute =
                timeOfRequest.stream().filter(request -> request + 60000 > currentTimeMillis).count();
        return requestsInLastMinute > max_num_requests_per_minute;
    }
}

package chain_of_responsibility;

public abstract class Handler {
    protected Handler next;

    public abstract boolean handle(String email, String password);

    protected boolean handleNext(String email, String password) {
        // Alternative:
        // return next == null || next.handle(email, password);
        if (next != null) {
            return next.handle(email, password);
        }
        return true;
    }

    public void setNext(Handler next) {
        this.next = next;
    }
}

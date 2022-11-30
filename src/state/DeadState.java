package state;

public class DeadState implements State {
    @Override
    public String dance() {
        return "(x _ x)";
    }

    @Override
    public String feed() {
        return "(x _ x)  <*)))<";
    }

    @Override
    public String status() {
        return "(x _ x)";
    }
}

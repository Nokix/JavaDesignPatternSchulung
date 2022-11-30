package state;

public class Tamagotchi {
    private State state = new NormalState(this);
    private int energy = 3;

    public void setState(State state) {
        this.state = state;
    }

    public int getEnergy() {
        return energy;
    }

    public void changeEnergy(int delta) {
        this.energy += delta;
    }

    public String feed() {
        return state.feed();
    }

    public String dance() {
        return state.dance();
    }

    public String status() {
        return state.status();
    }
}

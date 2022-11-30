package state;

public class HungryState implements State {

    private final Tamagotchi tamagotchi;

    public HungryState(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    @Override
    public String dance() {
        tamagotchi.changeEnergy(-1);
        if (tamagotchi.getEnergy() <= 0) tamagotchi.setState(new DeadState());
        return "(_ . _ )";
    }

    @Override
    public String feed() {
        tamagotchi.changeEnergy(3);
        tamagotchi.setState(new HappyState(tamagotchi));
        return "( ^o^)  <')))<";
    }

    @Override
    public String status() {
        return "( _ . _)";
    }
}

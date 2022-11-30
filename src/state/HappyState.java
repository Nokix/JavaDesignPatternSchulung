package state;

public class HappyState implements State {
    Tamagotchi tamagotchi;

    public HappyState(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }

    @Override
    public String dance() {
        tamagotchi.changeEnergy(-1);
        tamagotchi.setState(new NormalState(tamagotchi));
        return "~(^ _^ ~)  ~( ^_^ )~  ~(^ _^ ~)";
    }

    @Override
    public String feed() {
        return "(^_^ ) no  <*)))<";
    }

    @Override
    public String status() {
        return "\\( ^o^)/";
    }
}

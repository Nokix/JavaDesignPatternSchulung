package Adapter.ourCode;

public class Zoll {

    private int max_euros;

    public Zoll(int max_euros) {
        this.max_euros = max_euros;
    }

    public boolean billable(Billable einwohner) {
        return einwohner.getEuros() > max_euros;
    }
}

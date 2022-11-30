package Adapter.ourCode;

public class Einwohner implements Billable{
    private int euros;

    public Einwohner(int euros) {
        this.euros = euros;
    }

    @Override
    public int getEuros() {
        return euros;
    }
}

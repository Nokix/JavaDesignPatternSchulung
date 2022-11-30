package Adapter.ourCode;

import Adapter.theirCode.CitizanOfUSA;

public class CitizanOfUSAAdapter extends CitizanOfUSA implements Billable{

    public CitizanOfUSAAdapter(int dollars) {
        super(dollars);
    }

    @Override
    public int getEuros() {
        return (int) (getDollars() * 1.064);
    }
}

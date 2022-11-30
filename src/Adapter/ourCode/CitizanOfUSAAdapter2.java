package Adapter.ourCode;

import Adapter.theirCode.CitizanOfUSA;

public class CitizanOfUSAAdapter2 implements Billable{
    CitizanOfUSA citizan;

    public CitizanOfUSAAdapter2(CitizanOfUSA citizan) {
        this.citizan = citizan;
    }

    @Override
    public int getEuros() {
        return (int) (citizan.getDollars() * 1.064);
    }
}

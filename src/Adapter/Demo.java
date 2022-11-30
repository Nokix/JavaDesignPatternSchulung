package Adapter;

import Adapter.ourCode.*;
import Adapter.theirCode.CitizanOfUSA;

public class Demo {
    public static void main(String[] args) {
        Einwohner otto = new Einwohner(200);
        Einwohner franzi = new Einwohner(30);
        Zoll zoll = new Zoll(100);

        System.out.println("Otto hat zu viel Geld: " + zoll.billable(otto));
        System.out.println("Franzi hat zu viel Geld: " + zoll.billable(franzi));

        // Variante 1:
        Billable steve = new CitizanOfUSAAdapter(99);
        System.out.println("Steve hat zu viel Geld: " + zoll.billable(steve));

        // Variante 2:
        Billable clara = new CitizanOfUSAAdapter2(new CitizanOfUSA(22));
        System.out.println("Clara hat zu viel Geld: " + zoll.billable(clara));


    }
}

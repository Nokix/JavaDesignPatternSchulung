package visitor.exporter;

import visitor.AmazonRecord;
import visitor.BankRecord;

public interface Exporter {

    String export(BankRecord bankRecord);

    String export(AmazonRecord amazonRecord);

    default String notJetImplemented(Object obj) {
        return null;
    }
}

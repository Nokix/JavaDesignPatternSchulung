package visitor;

import visitor.exporter.Exportable;
import visitor.exporter.Exporter;

import java.util.Date;

public class BankRecord implements Exportable {
    private final long amount;
    private final Date date;

    public BankRecord(long amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public long getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "BankRecord{" +
                "amount=" + amount +
                ", date=" + date +
                '}';
    }

    public String export(Exporter exporter) {
        return exporter.export(this);
    }
}

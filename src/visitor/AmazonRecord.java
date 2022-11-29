package visitor;

import visitor.exporter.Exportable;
import visitor.exporter.Exporter;

import java.util.Date;

public class AmazonRecord implements Exportable {
    private final long amount;
    private final Date date;
    private final long points;

    public AmazonRecord(long amount, Date date, long points) {
        this.amount = amount;
        this.date = date;
        this.points = points;
    }

    public long getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public long getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "AmanzonRecord{" +
                "amount=" + amount +
                ", date=" + date +
                ", points=" + points +
                '}';
    }

    public String export(Exporter exporter) {
        return exporter.export(this);
    }
}

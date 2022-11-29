package visitor.exporter;

import visitor.AmazonRecord;
import visitor.BankRecord;

import java.text.SimpleDateFormat;

public class CSVExporter implements Exporter{
    private final String seperator = ";";

    @Override
    public String export(BankRecord record) {
        String date = new SimpleDateFormat("dd.MM.yyyy").format(record.getDate());
        return date + seperator + record.getAmount();
    }

    @Override
    public String export(AmazonRecord record) {
        String date = new SimpleDateFormat("dd.MM.yyyy").format(record.getDate());
        return date + seperator + record.getAmount() + seperator + record.getPoints();
    }
}

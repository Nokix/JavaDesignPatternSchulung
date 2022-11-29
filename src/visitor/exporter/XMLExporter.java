package visitor.exporter;

import visitor.AmazonRecord;
import visitor.BankRecord;

import java.text.SimpleDateFormat;

public class XMLExporter implements Exporter{
    private final static String INLINE = "   ";

    @Override
    public String export(BankRecord record) {
        String date = new SimpleDateFormat("dd.MM.yyyy").format(record.getDate());

        return "<record type=\"bank\">\n"
                + INLINE + "<amount>" + record.getAmount() + "</amount>\n"
                + INLINE + "<date>" + date + "</date>\n"
                + "</record>";
    }

    @Override
    public String export(AmazonRecord record) {
        String date = new SimpleDateFormat("dd.MM.yyyy").format(record.getDate());

        return "<record type=\"amazon\">\n"
                + INLINE + "<amount>" + record.getAmount() + "</amount>\n"
                + INLINE + "<date>" + date + "</date>\n"
                + INLINE + "<points>" + record.getPoints() + "</points>\n"
                + "</record>";
    }
}

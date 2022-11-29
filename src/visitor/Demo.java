package visitor;

import visitor.exporter.CSVExporter;
import visitor.exporter.Exportable;
import visitor.exporter.XMLExporter;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Exportable> records = new ArrayList<>();
        records.add(new AmazonRecord(30, new Date(100000), 10));
        records.add(new AmazonRecord(60, new Date(200000), 20));
        records.add(new BankRecord(65, new Date(300000)));
        records.add(new BankRecord(55, new Date(400000)));

        XMLExporter xmlExporter = new XMLExporter();
        for (Exportable record : records) {
            System.out.println(record.export(xmlExporter));
        }


        CSVExporter csvExporter = new CSVExporter();
        for (Exportable record : records) {
            System.out.println(record.export(csvExporter));
        }

    }
}

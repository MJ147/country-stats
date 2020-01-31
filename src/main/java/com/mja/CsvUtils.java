package com.mja;

import com.mja.models.Country;
import com.mja.models.DataModel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CsvUtils {

    private DataModel dataModel = new DataModel();

    public static final String NAME = "Country (region)";
    public static final String HAPPINESS = "Ladder";
    public static final String FREEDOM = "Freedom";
    public static final String CORRUPTION = "Corruption";

    public void covertCsvToModel() throws IOException {
        Reader in = new FileReader("book.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(NAME, HAPPINESS, FREEDOM, CORRUPTION)
                .withFirstRecordAsHeader()
                .parse(in);
        for (CSVRecord record : records) {
            String countryName = record.get(NAME);
            int happiness = Integer.parseInt(record.get(HAPPINESS));
            int freedom = Integer.parseInt(record.get(FREEDOM));
            int corruption = Integer.parseInt(record.get(CORRUPTION));

            Country country = new Country(countryName, happiness, freedom, corruption);
            dataModel.addCountry(country);
        }
    }

}

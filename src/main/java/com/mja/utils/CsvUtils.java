package com.mja.utils;

import com.mja.models.Country;
import com.mja.models.DataModel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CsvUtils {

    private DataModel dataModel;

    public CsvUtils(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public static final String NAME = "Country (region)";
    public static final String HAPPINESS = "Ladder";
    public static final String FREEDOM = "Freedom";
    public static final String CORRUPTION = "Corruption";

    public void covertCsvToModel() throws IOException {
        Reader in = new FileReader("src\\main\\resources\\Happiness.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(NAME, HAPPINESS, FREEDOM, CORRUPTION)
                .withFirstRecordAsHeader()
                .parse(in);
        for (CSVRecord record : records) {
            String countryName = record.get(NAME);
            int happiness = parseToInteger(record.get(HAPPINESS));
            int freedom = parseToInteger(record.get(FREEDOM));
            int corruption = parseToInteger(record.get(CORRUPTION));

            Country country = new Country(countryName, happiness, freedom, corruption);
            dataModel.addCountry(country);
        }
    }

    private int parseToInteger(String record) {
        if ("".equals(record)) {
            record = "0";
        }

        return Integer.parseInt(record);
    }





}

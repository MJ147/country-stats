package com.mja;

import com.mja.models.DataModel;

import java.io.IOException;

public class App {

    public static void main(String[] args) {

        DataModel model = new DataModel();
        CsvUtils utils = new CsvUtils(model);

        try {
            utils.covertCsvToModel();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package com.mja;

import com.mja.models.DataModel;
import com.mja.utils.CsvUtils;
import com.mja.utils.ModelUtils;
import com.mja.utils.TxtUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        DataModel dataModel = new DataModel();
        CsvUtils csvUtils = new CsvUtils(dataModel);
        ModelUtils modelUtils = new ModelUtils(dataModel);

        try {
            csvUtils.covertCsvToModel();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> countriesWithHappinessGreaterThenInPoland = modelUtils.findCountriesWithHappinessGreatestThenInPoland();
        String[] countriesWithGreatestFreedom = modelUtils.findCountriesWithGreatestFreedom();
        String[] countriesWithLowestCorruption = modelUtils.findCountriesWithLowestCorruption();
        List<String> countriesWithGreatestCorruption = modelUtils.findCountriesWithGreatestCorruption();

        try {
            TxtUtils.covertListToTxt(countriesWithHappinessGreaterThenInPoland, "Happiness greater than in Poland");
            TxtUtils.covertListToTxt(Arrays.asList(countriesWithGreatestFreedom), "Top 5 Freedom");
            TxtUtils.covertListToTxt(Arrays.asList(countriesWithLowestCorruption), "5 lowest Corruption");
            TxtUtils.covertListToTxt(countriesWithGreatestCorruption, "5 greatest Corruption");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

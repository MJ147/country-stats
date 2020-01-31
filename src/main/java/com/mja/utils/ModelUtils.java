package com.mja.utils;

import com.mja.models.Country;
import com.mja.models.DataModel;

import java.util.ArrayList;
import java.util.List;

public class ModelUtils {

    private DataModel model;

    public ModelUtils(DataModel model) {
        this.model = model;
    }

    public List<String> findCountriesWithHappinessGreatestThenInPoland() {

        List<String> countryNameList = new ArrayList<>();

        for (Country country : model.getCountries()) {
            if ("Poland".equals(country.getName())) {
                return countryNameList;
            }
            countryNameList.add(country.getName());
        }
        return countryNameList;

    }

    public String[] findCountriesWithGreatestFreedom() {

        String countryNameList[] = new String[5];
        int limit = 5;

        for (Country country : model.getCountries()) {
            if (country.getFreedom() <= limit && country.getFreedom() != 0) {
                countryNameList[country.getFreedom()-1] = country.getName();
            }
        }
        return countryNameList;
    }

    public String[] findCountriesWithLowestCorruption() {

        String countryNameList[] = new String[5];
        int limit = 5;

        for (Country country : model.getCountries()) {
            if (country.getCorruption() <= limit && country.getCorruption() != 0) {
                countryNameList[country.getCorruption()-1] = country.getName();
            }
        }
        return countryNameList;
    }

    public List<String> findCountriesWithGreatestCorruption() {

        List<String> countryNameList = new ArrayList<>();
        int limit = 5;
        int max = 0;
        String name = "";
        for (int i = 0; i < limit; i++) {
            for (Country country : model.getCountries()) {
                if (country.getCorruption() > max  && !countryNameList.contains(country.getName())) {
                    max = country.getCorruption();
                    name = country.getName();
                }
            }
            max = 0;
            countryNameList.add(name);
        }
        return countryNameList;
    }
}

package com.mja.models;

import java.util.ArrayList;
import java.util.List;

public class DataModel {

    private List<Country> countries;

    public DataModel() {
        this.countries = new ArrayList<Country>();
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void addCountry(Country country) {
        countries.add(country);
    }
}

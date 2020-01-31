package com.mja;

import com.mja.models.DataModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CsvUtilsTest {

    DataModel model = new DataModel();
    CsvUtils utils = new CsvUtils(model);

    @Test
    void convertCsvToModelTest() throws IOException {
        utils.covertCsvToModel();
        Assertions.assertEquals(model.getCountries().get(57).getName(), "Japan");
    }
}
